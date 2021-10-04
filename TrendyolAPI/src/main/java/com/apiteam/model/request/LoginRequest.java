package com.apiteam.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class LoginRequest {
    private String username;
    private String password;
}
