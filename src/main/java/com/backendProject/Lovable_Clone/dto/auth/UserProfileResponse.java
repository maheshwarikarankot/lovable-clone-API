package com.backendProject.Lovable_Clone.dto.auth;

public record UserProfileResponse(
        Long id,
        String username,
        String name
//        String avatarUrl
) {
}
