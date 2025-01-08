package com.example.first_sprint.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AppController {

    @GetMapping("/greet")
    @Operation(summary = "Get Greeting", description = "Returns a greeting message.")
    public String getGreeting() {
        return "Hello this is the first sprint! :)))";
    }

    @PostMapping("/submit")
    @Operation(summary = "Submit Data", description = "Receives data and returns a confirmation message.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data successfully received."),
            @ApiResponse(responseCode = "400", description = "Bad request, invalid data.")
    })
    public String submitData(@RequestBody String data) {
        return "Data received succesfully: " + data;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get the id", description = "Retrieves the id passed in the url")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Id successfully received."),
            @ApiResponse(responseCode = "400", description = "Bad request, invalid id.")
    })
    public String getUserById(@PathVariable("id") Long id) {
        return "User ID: " + id;
    }

    @GetMapping("/search")
    @Operation(summary = "Get the param", description = "Retrieves the param passed in the url to make a search")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Parameter of query successfully received."),
            @ApiResponse(responseCode = "400", description = "Bad request, invalid search.")
    })
    public String search(@RequestParam(name = "query", defaultValue = "")
                             @Parameter(description = "Search query") String query) {
        return "Search results for: " + query;
    }
}
