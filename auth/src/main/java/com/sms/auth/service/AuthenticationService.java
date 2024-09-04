package com.sms.auth.service;

import com.sms.auth.dto.UserLoginRequestDto;
import com.sms.auth.model.User;

public interface AuthenticationService {
    User authenticate(UserLoginRequestDto userDetails);
}
