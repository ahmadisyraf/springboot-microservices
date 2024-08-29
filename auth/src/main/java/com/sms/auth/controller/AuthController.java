package com.sms.auth.controller;

import com.sms.auth.dto.AuthResponseDto;
import com.sms.auth.dto.GetUserResponseDto;
import com.sms.auth.dto.UserLoginRequestDto;
import com.sms.auth.service.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController()
@RequestMapping(value = "auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    ModelMapper modelMapper = new ModelMapper();

    @GetMapping(value = "{id}")
    public ResponseEntity<Optional<GetUserResponseDto>> getUser(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.getUser(id));

    }
}
