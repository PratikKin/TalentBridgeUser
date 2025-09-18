package com.TalentBridgeUser.controller;

import com.TalentBridgeUser.wrapper.SigninRequest;
import com.TalentBridgeUser.wrapper.SigninResponse;
import com.TalentBridgeUser.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signin")
    public SigninResponse signin(@RequestBody SigninRequest request) {
        return authService.signin(request);
    }
}
