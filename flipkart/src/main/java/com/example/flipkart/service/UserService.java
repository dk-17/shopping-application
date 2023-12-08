package com.example.flipkart.service;

import com.example.flipkart.dto.UserDto;
import com.example.flipkart.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(UserDto userDto) {
        userRepository.addUser(userDto);
        log.info("{} register successfully", userDto.getName());
    }
}
