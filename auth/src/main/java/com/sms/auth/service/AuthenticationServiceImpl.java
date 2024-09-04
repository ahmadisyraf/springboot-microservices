package com.sms.auth.service;

import com.sms.auth.dto.UserLoginRequestDto;
import com.sms.auth.model.User;
import com.sms.auth.repository.UserRepository;
import com.sms.auth.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository repository;
    private final AuthenticationManager authenticationManager;


    public AuthenticationServiceImpl(UserRepository repository, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.authenticationManager = authenticationManager;
    }

    public User authenticate(UserLoginRequestDto userDetails) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDetails.getEmail(),
                        userDetails.getPassword()
                )
        );

        return repository.findByEmail(userDetails.getEmail())
                .orElseThrow();
    }
}
