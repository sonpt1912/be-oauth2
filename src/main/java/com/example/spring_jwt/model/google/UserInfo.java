package com.example.spring_jwt.model.google;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserInfo {

    private String iss;

    private String azp;

    private String aud;

    private String sub;

    private String email;

    private Boolean email_verified;

    private Integer nbf;

    private String name;

    private String picture;

    private String given_name;

    private String family_name;

    private String locale;

    private Integer iat;

    private Integer exp;

    private String jti;
}
