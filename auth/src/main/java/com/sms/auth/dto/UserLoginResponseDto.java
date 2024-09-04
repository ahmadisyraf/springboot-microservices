package com.sms.auth.dto;

import lombok.Data;

@Data
public class UserLoginResponseDto {
    private String accessToken;
    private Long expiresIn;
}
