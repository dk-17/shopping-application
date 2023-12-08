package com.example.flipkart.repository;

import com.example.flipkart.dto.UserDto;
import com.example.flipkart.entity.UserEntity;

import java.util.HashMap;

public class UserRepository {
    HashMap<Integer, UserEntity> users = new HashMap<>();

    public void addUser(UserDto userDto) {
        UserEntity user = new UserEntity();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setCredit(user.getCredit());

        users.put(userDto.getId(), user);
    }
}
