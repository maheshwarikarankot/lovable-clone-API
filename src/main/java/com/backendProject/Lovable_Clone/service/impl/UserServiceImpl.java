package com.backendProject.Lovable_Clone.service.impl;

import com.backendProject.Lovable_Clone.dto.auth.UserProfileResponse;
import com.backendProject.Lovable_Clone.error.ResourceNotFoundException;
import com.backendProject.Lovable_Clone.repository.UserRepository;
import com.backendProject.Lovable_Clone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserProfileResponse getProfile(Long userid) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("user",username));
    }
}
