package com.denpaden.springrestapi.database;

/**
 * Created by DenPaden on 18/08/2022.
 */

import com.denpaden.springrestapi.model.User;
import com.denpaden.springrestapi.repo.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private UserRepo userRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepo userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Delete all
        //  this.userRepository.deleteAll();

        // Crete users
        User den = new User("den", passwordEncoder.encode("den123"), "USER", "ACCESS_TEST1");
        User admin = new User("admin", passwordEncoder.encode("admin123"), "ADMIN", "ACCESS_TEST1,ACCESS_TEST2");
        User manager = new User("manager", passwordEncoder.encode("manager123"), "MANAGER", "ACCESS_TEST1");

        List<User> users = Arrays.asList(den, admin, manager);
        // Save to db
        // this.userRepository.saveAll(users);
    }
}
