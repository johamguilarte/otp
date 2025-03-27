package com.app.softwater.controller;

import com.app.softwater.dto.UserRegistrationRequestDTO;
import com.app.softwater.service.KeycloakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private KeycloakService keycloakService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequestDTO request) {
        try {
            String userId = keycloakService.createUser(request.getUsername(), request.getEmail(), request.getPassword());
            // Optionally, save user information to your database here.
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado con éxito. ID: " + userId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar el usuario: " + e.getMessage());
        }
    }
}