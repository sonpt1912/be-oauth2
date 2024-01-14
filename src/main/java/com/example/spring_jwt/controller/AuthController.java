package com.example.spring_jwt.controller;

import com.example.spring_jwt.dto.JwtRequest;
import com.example.spring_jwt.dto.JwtResponse;
import com.example.spring_jwt.dto.TokenRequest;
import com.example.spring_jwt.model.User;
import com.example.spring_jwt.model.google.UserInfo;
import com.example.spring_jwt.security.JwtProvider;
import com.example.spring_jwt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }


    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtProvider.generateToken(userDetails);
        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/login-google")
    public Object loginGoogle(@RequestBody TokenRequest crenditial) throws NoSuchAlgorithmException, InvalidKeySpecException {
        UserInfo user = (UserInfo) jwtProvider.getAllClaimsFromToken(crenditial.getCrenditial());
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
        JwtResponse response = JwtResponse.builder()
                .jwtToken(jwtProvider.generateToken(userDetails))
                .username(userDetails.getUsername()).build();
        return response;
    }


}
