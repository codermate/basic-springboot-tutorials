package com.dncoder.springopenapi.controller;


import com.dncoder.springopenapi.controller.response.Response;
import com.dncoder.springopenapi.model.User;
import com.dncoder.springopenapi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "This is for save data user into database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Save data User is success", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Not available", content = @Content)
    })
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Response> save(@RequestBody User request) {
        User save = userService.save(request);
        Response statusResponse = new Response(HttpStatus.OK.toString(), "User saved succes", save);
        return new ResponseEntity<>(statusResponse, HttpStatus.OK);
    }

    @Operation(summary = "This is for get all data user into database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "get all data user  is success", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Not available", content = @Content)
    })
    @GetMapping("/getAll")
    public ResponseEntity<Response> getAll() {
        List<User> list = userService.getAll();
        Response statusResponse = new Response(HttpStatus.OK.toString(), "User list", list);
        return new ResponseEntity<>(statusResponse, HttpStatus.OK);
    }


}
