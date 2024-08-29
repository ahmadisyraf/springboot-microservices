package com.sms.users.dto;

import lombok.Data;
import org.springframework.http.HttpStatusCode;

import java.util.UUID;

@Data
public class GetUserResponseDto {
    private UUID id;
    private String name;
    private String email;
}
