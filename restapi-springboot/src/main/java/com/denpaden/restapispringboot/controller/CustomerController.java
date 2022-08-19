package com.denpaden.restapispringboot.controller;

import com.denpaden.restapispringboot.controller.response.Response;
import com.denpaden.restapispringboot.model.Customer;
import com.denpaden.restapispringboot.service.CustomerService;
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


    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Response> save(@RequestBody Customer customer) {
        Customer save = customerService.save(customer);
        Response statusResponse = new Response(HttpStatus.OK.toString(), "Customer saved succes", save);
        return new ResponseEntity<>(statusResponse, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Response> getAll() {
        List<Customer> list = customerService.getAll();
        Response statusResponse = new Response(HttpStatus.OK.toString(), "Customer list", list);
        return new ResponseEntity<>(statusResponse, HttpStatus.OK);
    }

}
