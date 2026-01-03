package com.backendProject.Lovable_Clone.dto.member;

import com.backendProject.Lovable_Clone.enums.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long userId,
        String email,
        String name,
//        String avatarUrl,
        ProjectRole projectRole,
        Instant invitedAt
) {
}
