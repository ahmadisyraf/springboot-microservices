package com.sms.auth.service;

import com.sms.auth.dto.GetUserResponseDto;
import com.sms.auth.dto.UserLoginRequestDto;

import java.util.Optional;
import java.util.UUID;

public interface AuthService {
    public Optional<GetUserResponseDto> getUser(UUID id) ;
}
