package com.backendProject.Lovable_Clone.service;

import com.backendProject.Lovable_Clone.dto.auth.AuthResponse;
import com.backendProject.Lovable_Clone.dto.auth.LoginRequest;
import com.backendProject.Lovable_Clone.dto.auth.SignUpRequest;

public interface AuthService {
    AuthResponse signup(SignUpRequest request);

    AuthResponse login(LoginRequest request);
}
