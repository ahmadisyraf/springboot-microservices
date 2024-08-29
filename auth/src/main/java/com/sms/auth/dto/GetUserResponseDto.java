package com.sms.auth.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class GetUserResponseDto {
    private UUID id;
    private String name;
    private String email;
}
