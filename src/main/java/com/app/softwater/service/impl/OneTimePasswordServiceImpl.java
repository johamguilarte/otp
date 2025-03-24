package com.app.softwater.service.impl;

import com.app.softwater.entity.OneTimePassword;
import com.app.softwater.repository.OneTimePasswordRepository;
import com.app.softwater.service.OneTimePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class OneTimePasswordServiceImpl implements OneTimePasswordService {

    @Autowired
    OneTimePasswordRepository repository;

    @Override
    public Integer generateOTP() {
        SecureRandom random = new SecureRandom();
        int otp = 100000 + random.nextInt(900000); // OTP de 6 dígitos

        Date expires = new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMinutes(5));

        OneTimePassword oneTimePassword = new OneTimePassword();
        oneTimePassword.setOneTimePasswordCode(123456);
        oneTimePassword.setExpires(expires);

        repository.save(oneTimePassword);
        return otp;
    }

    @Override
    public boolean verifyOTP(Integer otp) {
        Date now = new Date();
        Optional<OneTimePassword> oneTimePassword = repository.findByOneTimePasswordCodeAndExpiresAfter(otp, now);

        if (oneTimePassword.isPresent()) {
            repository.deleteById(oneTimePassword.get().getId());
            return true;
        }
        return false;
    }
}
