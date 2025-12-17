package com.backendProject.Lovable_Clone.service;

import com.backendProject.Lovable_Clone.dto.auth.UserProfileResponse;

public interface UserService {
    UserProfileResponse getProfile(Long userid);
}
