package com.TalentBridgeUser.service;

import com.TalentBridgeUser.wrapper.SigninRequest;
import com.TalentBridgeUser.wrapper.SigninResponse;
import com.TalentBridgeUser.model.AuthCredentials;
import com.TalentBridgeUser.model.User;
import com.TalentBridgeUser.repository.AuthCredentialsRepository;
import com.TalentBridgeUser.repository.UserRepository;
import com.TalentBridgeUser.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final AuthCredentialsRepository authCredentialsRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public SigninResponse signin(SigninRequest request) {
        // 1. Find user by email
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 2. Get credentials
        AuthCredentials credentials = authCredentialsRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Credentials not found"));

        // 3. Check password
        if (!passwordEncoder.matches(request.getPassword(), credentials.getPasswordHash())) {
            throw new RuntimeException("Invalid password");
        }

        // 4. Generate JWT
        String token = jwtUtil.generateToken(user.getUserId(), user.getEmail(), user.getRole().toString());
        System.out.println(token);
        return SigninResponse.builder()
                .accessToken(token)
                .tokenType("Bearer")
                .build();
    }
}
