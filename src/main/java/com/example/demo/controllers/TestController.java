package com.example.demo.controllers;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Getter
@Setter
public class TestController {

    @GetMapping(value = "/test")
    public String getTestData() {
        return "Hello world!";
    }

}
