package com.denpaden.springrestapi.security.jwt;

import com.auth0.jwt.JWT;
import com.denpaden.springrestapi.model.User;
import com.denpaden.springrestapi.repo.UserRepo;
import com.denpaden.springrestapi.security.UserPrincipal;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    private UserRepo userRepository;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UserRepo userRepository) {
        super(authenticationManager);
        this.userRepository = userRepository;
    }

    @Override // api public akan di filter di function ini, apakah header sudah sesuai dengan yg diminta oleh security
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Read the Authorization header, where the JWT token should be
        String header = request.getHeader(JwtProperties.TOKEN_X_KEY);

        // If header does not contain X-AUTH-TOKEN or is null delegate to Spring impl and exit
        if (header == null || !header.startsWith(JwtProperties.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }

        // If header is present, try grab user principal from database and perform authorization
        Authentication authentication = getUsernamePasswordAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Continue filter execution
        chain.doFilter(request, response);
    }

    private Authentication getUsernamePasswordAuthentication(HttpServletRequest request) {
        String token = request.getHeader(JwtProperties.TOKEN_X_KEY)
                .replace(JwtProperties.TOKEN_PREFIX,"");

        if (token != null) {
            // parse the token and validate it
            String userName = JWT.require(HMAC512(JwtProperties.TOKEN_SECRET.getBytes()))
                    .build()
                    .verify(token)
                    .getSubject();

            // Search in the DB if we find the user by token subject (username)
            // If so, then grab user details and create spring auth token using username, pass, authorities/roles
            if (userName != null) {
                User user = userRepository.findByUsername(userName);
                UserPrincipal principal = new UserPrincipal(user);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userName, null, principal.getAuthorities());
                return auth;
            }
            return null;
        }
        return null;
    }
}
