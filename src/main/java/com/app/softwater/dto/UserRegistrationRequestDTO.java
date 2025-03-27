package com.app.softwater.dto;

import lombok.Data;

@Data
public class UserRegistrationRequestDTO {
    private String username;
    private String email;
    private String password;
}
