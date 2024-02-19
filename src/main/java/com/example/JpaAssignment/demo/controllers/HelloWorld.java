package com.example.JpaAssignment.demo.controllers;

import com.example.JpaAssignment.demo.beans.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2/helloworld")
public class HelloWorld {

    @GetMapping("/")
    public ResponseEntity<Object> getHelloWorld(){
        return ResponseHandler.createResponse("Success", HttpStatus.OK, "Hello World!");
    }

}
