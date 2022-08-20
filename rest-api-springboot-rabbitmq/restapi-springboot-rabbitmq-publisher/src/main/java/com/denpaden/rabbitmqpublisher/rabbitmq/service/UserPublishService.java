package com.denpaden.rabbitmqpublisher.rabbitmq.service;

import com.denpaden.rabbitmqpublisher.rabbitmq.dto.UserMessageDto;
import org.springframework.stereotype.Service;

/**
 * Created by DenPaden on 19/08/2022.
 */
@Service
public interface UserPublishService {
    public UserMessageDto getByUsername(String username);
}
