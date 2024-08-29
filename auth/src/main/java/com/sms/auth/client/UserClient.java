package com.sms.auth.client;

import com.sms.auth.dto.GetUserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.UUID;

@FeignClient(name = "users", url = "http://localhost:8080")
public interface UserClient {
    @GetMapping(value = "/users/{id}")
    public ResponseEntity<Optional<GetUserResponseDto>> getUsers(@PathVariable UUID id);
}
