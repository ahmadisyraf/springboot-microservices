package com.sms.users.dto;

import lombok.Data;
import org.springframework.http.HttpStatusCode;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
public class GetUserResponseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 6527855645691638321L;

    private UUID id;
    private String name;
    private String email;
}
