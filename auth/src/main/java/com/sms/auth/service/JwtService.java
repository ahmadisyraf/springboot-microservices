package com.sms.auth.service;

import com.sms.auth.model.User;

public interface JwtService {
    String generateToken(User user);
    Long getExpirationTime();
}
