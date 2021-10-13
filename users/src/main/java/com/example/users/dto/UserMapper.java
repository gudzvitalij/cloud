package com.example.users.dto;

import com.example.users.entity.User;

public class UserMapper {
    public UserDto toUserDto(User user){
        return new UserDto(user.getId(), user.getUsername());
    }
}
