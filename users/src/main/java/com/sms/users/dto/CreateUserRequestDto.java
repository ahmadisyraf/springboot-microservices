package com.sms.users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateUserRequestDto {
    @NotNull(message = "Name is required")
    private String name;
    @Email(message = "Wrong email format")
    @NotNull(message = "Email is required")
    private String email;
    @NotNull(message = "Password required")
    private String password;
}
