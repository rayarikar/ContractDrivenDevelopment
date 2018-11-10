package com.rohan.development.contractdrivendevelopmentsample.endpoints;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
@Api(value = "Hello World Endpoints", description = "Sample endpoints for hello world")
public class HelloWorldResource {

    @GetMapping(value = "/")
    @ApiOperation(value = "Gets a sample String response", response = String.class)
    public String helloWorld() {
        return "Hello world from SpringBoot";
    }
}
