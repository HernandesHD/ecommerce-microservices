package com.hernandes.andrade.userapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    public String getMessage() {
        return "Spring Boot is working!";
    }
}
