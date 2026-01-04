package com.backendProject.Lovable_Clone.service.impl;

import com.backendProject.Lovable_Clone.dto.auth.AuthResponse;
import com.backendProject.Lovable_Clone.dto.auth.LoginRequest;
import com.backendProject.Lovable_Clone.dto.auth.SignUpRequest;
import com.backendProject.Lovable_Clone.entity.User;
import com.backendProject.Lovable_Clone.error.BadRequestException;
import com.backendProject.Lovable_Clone.mapper.UserMapper;
import com.backendProject.Lovable_Clone.repository.UserRepository;
import com.backendProject.Lovable_Clone.security.AuthUtil;
import com.backendProject.Lovable_Clone.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthUtil authUtil;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse signup(SignUpRequest request) {
//        return null;
        userRepository.findByUsername(request.username())
                .ifPresent(user -> {
                    throw new BadRequestException("User already exists with username"+ request.username());
                });

        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        user = userRepository.save(user);

        String token = authUtil.generateAccessToken(user);

//        return new AuthResponse("dummy", userMapper.toUserProfileResponse(user));
        return new AuthResponse(token, userMapper.toUserProfileResponse(user));
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(),request.password())
        );
        User user = (User) authentication.getPrincipal();
        String token = authUtil.generateAccessToken(user);

        return new AuthResponse(token,userMapper.toUserProfileResponse(user));
//        return null;
    }
}
