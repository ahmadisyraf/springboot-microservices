package com.sms.users.service;

import com.sms.users.dto.CreateUserRequestDto;
import com.sms.users.dto.GetUserResponseDto;
import com.sms.users.dto.UpdateUserRequestDto;
import com.sms.users.model.User;
import com.sms.users.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public GetUserResponseDto createUser(CreateUserRequestDto userDetails) {

        User user = new User();

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(passwordEncoder.encode(userDetails.getPassword()));

        User createdUser = repository.save(user);

        return modelMapper.map(createdUser, GetUserResponseDto.class);
    }

    @Override
    public Optional<List<GetUserResponseDto>> getUsers() {
        List<User> users = repository.findAll();

        List<GetUserResponseDto> newUsers = users.stream().map(user -> modelMapper.map(user, GetUserResponseDto.class)).toList();

        return Optional.of(newUsers);
    }

    @Override
    public Optional<GetUserResponseDto> getUser(UUID id) {
        Optional<User> user = Optional.ofNullable(repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not exist")));

        return Optional.of(modelMapper.map(user, GetUserResponseDto.class));
    }

    @Override
    public GetUserResponseDto updateUser(UpdateUserRequestDto userDetails, UUID id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not exist"));

        user.setEmail(userDetails.getEmail());
        user.setName(userDetails.getName());
        user.setPassword(userDetails.getPassword());

        User updateUser = repository.save(user);

        return modelMapper.map(updateUser, GetUserResponseDto.class);
    }

    @Override
    public String deleteUser(UUID id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not exist"));

        repository.deleteById(user.getId());

        return "User deleted";
    }
}