package com.denpaden.restapispringboot.controller;

import com.denpaden.restapispringboot.controller.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
