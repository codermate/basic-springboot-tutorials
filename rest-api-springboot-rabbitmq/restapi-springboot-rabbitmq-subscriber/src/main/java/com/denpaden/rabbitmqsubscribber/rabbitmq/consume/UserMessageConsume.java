package com.denpaden.rabbitmqsubscribber.rabbitmq.consume;

import com.denpaden.rabbitmqsubscribber.rabbitmq.config.MessageConstant;
import com.denpaden.rabbitmqsubscribber.rabbitmq.dto.UserMessageResponseDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by DenPaden on 19/08/2022.
 */
@Component
public class UserMessageConsume {

    @RabbitListener(queues = MessageConstant.QUEUE_GET_USER)
    public void consumeMessageFromQueue(UserMessageResponseDto userMessageResponseDto) {
        System.out.println("Message received from Queue Rabbit :");
        System.out.println("id :" + userMessageResponseDto.getUser().getId());
        System.out.println("username :" + userMessageResponseDto.getUser().getUsername());
        System.out.println("password :" + userMessageResponseDto.getUser().getPassword());

    }
}
