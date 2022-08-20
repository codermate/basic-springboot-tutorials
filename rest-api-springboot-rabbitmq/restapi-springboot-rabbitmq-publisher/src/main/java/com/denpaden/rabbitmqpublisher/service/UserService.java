package com.denpaden.rabbitmqpublisher.service;

import com.denpaden.rabbitmqpublisher.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DenPaden on 18/08/2022.
 */
@Service
public interface UserService {
    public User save(User user);

    public User getByUserName(String username);

    public List<User> getAll();

}
