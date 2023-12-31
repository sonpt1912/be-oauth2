package com.example.spring_jwt.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class JwtRequest {

    private String username;

    private String password;

}
