package com.denpaden.springrestapi.security.jwt;

public class JwtProperties {
    public static final String TOKEN_SECRET= "SomeSecretForJWTGeneration";
    public static final int TOKEN_EXPIRED_TIME = 864_000_000; // 10 days
    public static final String TOKEN_X_KEY = "X-AUTH-TOKEN";
    public static final String TOKEN_PREFIX = TOKEN_X_KEY+".";

}
