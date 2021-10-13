package com.example.users.service;

import com.example.users.dto.UserDto;
import com.example.users.dto.UserMapper;
import com.example.users.entity.User;
import com.example.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<User> getUsers() {
        return userRepository.getAll();
    }

    public List<UserDto> getUsers(List<Long> usersId) {
       return usersId.stream()
               .map(userRepository::getById)
               .map(userMapper::toUserDto)
               .collect(Collectors.toList());
    }
}
