package com.sms.auth.service;

import com.sms.auth.dto.GetUserResponseDto;
import com.sms.auth.client.UserClient;
import com.sms.auth.dto.UserLoginRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserClient userClient;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Optional<GetUserResponseDto> getUser(UUID id) {
        return userClient.getUsers(id).getBody();
    }
}

