package com.denpaden.springrestapi.controller.response;

import java.util.Objects;

/**
 * Created by DenPaden on 18/08/2022.
 */
public class Response {

    String code;
    String message;
    Object data;

    public Response() {

    }

    public Response(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
