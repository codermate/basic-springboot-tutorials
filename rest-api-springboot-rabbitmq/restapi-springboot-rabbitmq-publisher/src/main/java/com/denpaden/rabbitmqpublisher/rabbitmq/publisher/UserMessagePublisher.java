package com.denpaden.rabbitmqpublisher.rabbitmq.publisher;

import com.denpaden.rabbitmqpublisher.controller.response.Response;
import com.denpaden.rabbitmqpublisher.rabbitmq.config.UserMessageConfig;
import com.denpaden.rabbitmqpublisher.rabbitmq.dto.UserMessageDto;
import com.denpaden.rabbitmqpublisher.rabbitmq.dto.UserMessageResponseDto;
import com.denpaden.rabbitmqpublisher.rabbitmq.service.UserPublishService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DenPaden on 19/08/2022.
 */
@RestController
@RequestMapping("/publish")
public class UserMessagePublisher {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    UserPublishService userPublishService;


    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Response> publishUser(@RequestBody UserMessageDto request) {
        UserMessageDto userMessageDto = userPublishService.getByUsername(request.getUsername());
        if (userMessageDto != null) {
            // publish message to rabbit mq
            rabbitTemplate.convertAndSend(
                    UserMessageConfig.EXCHANGE_GET_USER,
                    UserMessageConfig.BIND_GET_USER,
                    new UserMessageResponseDto(userMessageDto, "PROCESS", "User successfully publish " + userMessageDto.getUsername()));

            // write response
            Response statusResponse = new Response(HttpStatus.OK.toString(), "User successfully publish", userMessageDto);
            return new ResponseEntity<>(statusResponse, HttpStatus.OK);
        } else {
            Response statusResponse = new Response(HttpStatus.NOT_FOUND.toString(), "User not found", "");
            return new ResponseEntity<>(statusResponse, HttpStatus.NOT_FOUND);
        }
    }
}
