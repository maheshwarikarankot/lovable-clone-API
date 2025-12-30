package com.backendProject.Lovable_Clone.controller;

import com.backendProject.Lovable_Clone.dto.auth.AuthResponse;
import com.backendProject.Lovable_Clone.dto.auth.LoginRequest;
import com.backendProject.Lovable_Clone.dto.auth.SignUpRequest;
import com.backendProject.Lovable_Clone.dto.auth.UserProfileResponse;
import com.backendProject.Lovable_Clone.service.AuthService;
import com.backendProject.Lovable_Clone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody SignUpRequest request){
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile(){
        Long userid = 1L;
        return ResponseEntity.ok(userService.getProfile(userid));
    }
}
