package com.dncoder.springopenapi.controller;


import com.dncoder.springopenapi.controller.response.Response;
import com.dncoder.springopenapi.model.Customer;
import com.dncoder.springopenapi.service.CustomerService;
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
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Operation(summary = "This is for get all data Customer into database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "get all data Customer  is success", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Not available", content = @Content)
    })
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Response> save(@RequestBody Customer customer) {
        Customer save = customerService.save(customer);
        Response statusResponse = new Response(HttpStatus.OK.toString(), "Customer saved succes", save);
        return new ResponseEntity<>(statusResponse, HttpStatus.OK);
    }

    @Operation(summary = "This is for get all data Customer into database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "get all data Customer  is success", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Not available", content = @Content)
    })
    @GetMapping("/getAll")
    public ResponseEntity<Response> getAll() {
        List<Customer> list = customerService.getAll();
        Response statusResponse = new Response(HttpStatus.OK.toString(), "Customer list", list);
        return new ResponseEntity<>(statusResponse, HttpStatus.OK);
    }

}
