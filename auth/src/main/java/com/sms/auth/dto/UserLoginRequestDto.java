package com.sms.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserLoginRequestDto {
    @Email
    @NotNull
    public String email;
    @NotNull
    public String password;
}
