package com.denpaden.rabbitmqsubscribber.rabbitmq.dto;

/**
 * Created by DenPaden on 18/08/2022.
 */

public class UserMessageDto {

    Integer id;
    String username;
    String password;


    public UserMessageDto() {

    }


    public UserMessageDto(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
