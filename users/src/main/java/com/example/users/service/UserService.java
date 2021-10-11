package com.example.users.service;

import com.example.users.entity.User;
import com.example.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.getAll();
    }

    public List<User> getUsers(ArrayList<Long> usersId) {
        final List<User> users = new ArrayList<>();
        usersId.forEach(o-> users.add(userRepository.getById(o)));
        return users;
    }
}
