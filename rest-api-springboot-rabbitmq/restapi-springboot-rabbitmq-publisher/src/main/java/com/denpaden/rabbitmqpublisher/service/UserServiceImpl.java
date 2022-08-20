package com.denpaden.rabbitmqpublisher.service;

import com.denpaden.rabbitmqpublisher.model.User;
import com.denpaden.rabbitmqpublisher.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DenPaden on 18/08/2022.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public User getByUserName(String username) {
        return userRepo.getByUsername(username);
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }


}
