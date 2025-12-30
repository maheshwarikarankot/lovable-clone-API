package com.backendProject.Lovable_Clone.service.impl;

import com.backendProject.Lovable_Clone.dto.auth.AuthResponse;
import com.backendProject.Lovable_Clone.dto.auth.LoginRequest;
import com.backendProject.Lovable_Clone.dto.auth.SignUpRequest;
import com.backendProject.Lovable_Clone.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponse signup(SignUpRequest request) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
