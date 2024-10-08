package com.sms.users.controller;

import com.sms.users.dto.*;
import com.sms.users.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GetUserResponseDto> createUser(@Valid @RequestBody CreateUserRequestDto userDetails) {
        return new ResponseEntity<GetUserResponseDto>(userService.createUser(userDetails), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Cacheable(value = "users")
    ResponseEntity<Optional<List<GetUserResponseDto>>> getUsers() {
        return new ResponseEntity<Optional<List<GetUserResponseDto>>>(userService.getUsers(), HttpStatus.FOUND);
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Cacheable(value = "users", key = "#id", sync = true)
    Optional<GetUserResponseDto> getUser(@PathVariable UUID id) {
        return new ResponseEntity<Optional<GetUserResponseDto>>(userService.getUser(id), HttpStatus.FOUND).getBody();
    }

    @PatchMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    GetUserResponseDto updateUser(@Valid @RequestBody UpdateUserRequestDto newUserDetails, @PathVariable UUID id) {
        return new ResponseEntity<GetUserResponseDto>(userService.updateUser(newUserDetails, id), HttpStatus.ACCEPTED).getBody();
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    String deleteUser(@PathVariable UUID id) {
        return userService.deleteUser(id);
    }
}
