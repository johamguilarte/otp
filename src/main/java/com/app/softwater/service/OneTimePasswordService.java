package com.app.softwater.service;

public interface OneTimePasswordService {

    public Integer generateOTP();

    public boolean verifyOTP(Integer otp);
}
