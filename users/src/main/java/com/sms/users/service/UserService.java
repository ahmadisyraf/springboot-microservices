package com.sms.users.service;

import com.sms.users.dto.CreateUserRequestDto;
import com.sms.users.dto.GetUserResponseDto;
import com.sms.users.dto.UpdateUserRequestDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    GetUserResponseDto createUser(CreateUserRequestDto userDetails);
    Optional<List<GetUserResponseDto>> getUsers();
    Optional<GetUserResponseDto> getUser(UUID id);
    GetUserResponseDto updateUser(UpdateUserRequestDto userDetails, UUID id);
    String deleteUser(UUID id);
}
