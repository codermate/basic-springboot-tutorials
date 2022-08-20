package com.denpaden.rabbitmqpublisher.rabbitmq.service;

import com.denpaden.rabbitmqpublisher.model.User;
import com.denpaden.rabbitmqpublisher.rabbitmq.dto.UserMessageDto;
import com.denpaden.rabbitmqpublisher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by DenPaden on 19/08/2022.
 */
@Service
public class UserPublishServiceImpl implements UserPublishService {
    @Autowired
    UserService userService;

    @Override
    public UserMessageDto getByUsername(String username) {
        User user = userService.getByUserName(username);
        if (user != null) {
            UserMessageDto userMessageDto = new UserMessageDto(user.getUsername(), user.getPassword());
            userMessageDto.setId(user.getId());
            return userMessageDto;
        } else {
            return null;
        }
    }
}
