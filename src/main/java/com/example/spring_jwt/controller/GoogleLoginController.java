package com.example.spring_jwt.controller;

import com.example.spring_jwt.dto.TokenRequest;
import com.example.spring_jwt.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@RestController
@RequestMapping("/api")
public class GoogleLoginController {

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/login-google")
    public Object loginGoogle(@RequestBody TokenRequest crenditial) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return jwtProvider.getAllClaimsFromToken(crenditial.getCrenditial());
    }

}
