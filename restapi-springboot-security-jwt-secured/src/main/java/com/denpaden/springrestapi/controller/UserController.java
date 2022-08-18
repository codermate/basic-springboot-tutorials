package com.denpaden.springrestapi.controller;

import com.denpaden.springrestapi.controller.response.Response;
import com.denpaden.springrestapi.model.User;
import com.denpaden.springrestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by DenPaden on 18/08/2022.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Response> save(@RequestBody User request) {
        User save = userService.save(request);
        Response statusResponse = new Response(HttpStatus.OK.toString(), "User saved succes", save);
        return new ResponseEntity<>(statusResponse, HttpStatus.OK);
    }


    @GetMapping("/getAll")
    public ResponseEntity<Response> getAll() {
        List<User> list = userService.getAll();
        Response statusResponse = new Response(HttpStatus.OK.toString(), "User list", list);
        return new ResponseEntity<>(statusResponse, HttpStatus.OK);
    }


}
