package com.pdv.controller;

import com.pdv.dto.UserCreateDTO;
import com.pdv.entity.User;
import com.pdv.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public User createUser(@RequestBody UserCreateDTO dto) {
        return userService.createUser(dto);
    }

    @GetMapping
    public List<User> listUsers() {
        return userService.listUsers();
    }

}