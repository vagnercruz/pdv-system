package com.pdv.service;

import com.pdv.dto.UserCreateDTO;
import com.pdv.entity.User;
import com.pdv.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(UserCreateDTO dto) {

        User user = User.builder()
                .id(UUID.randomUUID())
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .role(dto.getRole())
                .active(true)
                .createdAt(LocalDateTime.now())
                .build();

        return userRepository.save(user);
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

}