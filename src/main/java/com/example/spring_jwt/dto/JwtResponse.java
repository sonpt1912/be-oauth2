package com.example.spring_jwt.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class JwtResponse {

    private String jwtToken;

    private String username;

    private String fullName;

}
