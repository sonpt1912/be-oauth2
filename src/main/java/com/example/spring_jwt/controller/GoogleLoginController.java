package com.example.spring_jwt.controller;

import com.example.spring_jwt.dto.TokenRequest;
import com.example.spring_jwt.model.google.UserInfo;
import com.example.spring_jwt.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@RestController
@RequestMapping("/api")
public class GoogleLoginController {

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login-google")
    public Object loginGoogle(@RequestBody TokenRequest crenditial) throws NoSuchAlgorithmException, InvalidKeySpecException {
        UserInfo user = (UserInfo) jwtProvider.getAllClaimsFromToken(crenditial.getCrenditial());
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
        return jwtProvider.generateToken(userDetails);
    }

}
