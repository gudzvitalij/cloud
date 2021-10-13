package com.example.users.controller;

import com.example.users.dto.UserDto;
import com.example.users.entity.User;
import com.example.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final Log logger = LogFactory.getLog(this.getClass());
    private final UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(@RequestHeader Optional<String> authorization) {
        logger.info("users");
        return userService.getUsers();
    }

    @PostMapping("/users/list")
    public List<UserDto> getUsersById(@RequestBody ArrayList<Long> usersId) {
        logger.info("users by id");
        return userService.getUsers(usersId);
    }
}
