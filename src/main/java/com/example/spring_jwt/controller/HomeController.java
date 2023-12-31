package com.example.spring_jwt.controller;

import com.example.spring_jwt.model.User;
import com.example.spring_jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/")
    public String hello() {
        return "hello";
    }


}
