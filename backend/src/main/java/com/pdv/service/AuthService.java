package com.pdv.service;

import com.pdv.dto.LoginRequestDTO;
import com.pdv.dto.LoginResponseDTO;
import com.pdv.entity.User;
import com.pdv.repository.UserRepository;
import com.pdv.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public LoginResponseDTO login(LoginRequestDTO dto) {

        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        System.out.println("RAW PASSWORD: " + dto.getPassword());
        System.out.println("DB PASSWORD: " + user.getPassword());
        System.out.println("MATCH: " + passwordEncoder.matches(dto.getPassword(), user.getPassword()));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtService.generateToken(user.getEmail());

        return new LoginResponseDTO(token);
    }

}