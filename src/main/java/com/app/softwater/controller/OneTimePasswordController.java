package com.app.softwater.controller;

import com.app.softwater.service.OneTimePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/softwater/otp")
public class OneTimePasswordController {

    @Autowired
    private OneTimePasswordService service;

    @PostMapping("/generate")
    public ResponseEntity<Integer> generateOTP() {
        Integer otp = service.generateOTP();
        return ResponseEntity.ok(otp);
    }

    @PostMapping("/verify")
    public ResponseEntity<String> verifyOTP(@RequestParam Integer otp) {
        if (service.verifyOTP(otp)) {
            return ResponseEntity.ok("OTP verificado");
        } else {
            return ResponseEntity.badRequest().body("OTP inválido");
        }
    }
}
