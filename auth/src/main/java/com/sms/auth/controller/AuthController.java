package com.sms.auth.controller;

import com.sms.auth.dto.UserLoginRequestDto;
import com.sms.auth.dto.UserLoginResponseDto;
import com.sms.auth.model.User;
import com.sms.auth.service.AuthenticationService;
import com.sms.auth.service.JwtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private JwtService jwtService;

    @PostMapping(value = "login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserLoginResponseDto> authenticateUser(@Valid @RequestBody UserLoginRequestDto userDetails) {
        User authenticatedUser = authenticationService.authenticate(userDetails);

        String jwtToken = jwtService.generateToken(authenticatedUser);
        Long expiration = jwtService.getExpirationTime();

        UserLoginResponseDto response = new UserLoginResponseDto();

        response.setAccessToken(jwtToken);
        response.setExpiresIn(expiration);

        return new ResponseEntity<UserLoginResponseDto>(response, HttpStatus.FOUND);
    }
}
