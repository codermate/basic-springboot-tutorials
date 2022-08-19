package com.dncoder.springopenapi.controller;

import com.dncoder.springopenapi.controller.response.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dncoder on 18/08/2022.
 */
@RestController
@RequestMapping("/api/report")
public class ReportController {

    @Operation(summary = "This is for generate report for salesinvoice")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "generate report for salesinvoice is success", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Not available", content = @Content)
    })
    @GetMapping("/salesinvoice")
    public ResponseEntity<Response> getAll() {

        Response statusResponse = new Response(HttpStatus.OK.toString(), "Report list", "Report");
        return new ResponseEntity<>(statusResponse, HttpStatus.OK);
    }

}
