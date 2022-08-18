package com.denpaden.springrestapi.controller;

import com.denpaden.springrestapi.controller.response.Response;
import com.denpaden.springrestapi.model.Customer;
import com.denpaden.springrestapi.service.CustomerService;
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
@RequestMapping("/api/report")
public class ReportController {


    @GetMapping("/salesinvoice")
    public ResponseEntity<Response> getAll() {

        Response statusResponse = new Response(HttpStatus.OK.toString(), "Report list", "Report");
        return new ResponseEntity<>(statusResponse, HttpStatus.OK);
    }

}
