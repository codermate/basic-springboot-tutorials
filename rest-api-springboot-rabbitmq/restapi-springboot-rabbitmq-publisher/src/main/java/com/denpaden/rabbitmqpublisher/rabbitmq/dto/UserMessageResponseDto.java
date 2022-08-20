package com.denpaden.rabbitmqpublisher.rabbitmq.dto;

/**
 * Created by DenPaden on 19/08/2022.
 */

public class UserMessageResponseDto {
    private UserMessageDto user;
    private String status;
    private String message;

    public UserMessageResponseDto() {

    }

    public UserMessageResponseDto(UserMessageDto user, String status, String message) {
        this.user = user;
        this.status = status;
        this.message = message;
    }

    public UserMessageDto getUser() {
        return user;
    }

    public void setUser(UserMessageDto user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
