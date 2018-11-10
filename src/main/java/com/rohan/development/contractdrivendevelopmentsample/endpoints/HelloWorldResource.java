package com.rohan.development.contractdrivendevelopmentsample.endpoints;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

    @RequestMapping("/")
    public String helloWorld() {
        return "Hello world from SpringBoot";
    }
}
