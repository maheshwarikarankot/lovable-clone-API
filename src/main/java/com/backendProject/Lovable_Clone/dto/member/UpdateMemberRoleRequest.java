package com.backendProject.Lovable_Clone.dto.member;

import com.backendProject.Lovable_Clone.enums.ProjectRole;

public record UpdateMemberRoleRequest(
        ProjectRole role
) {
}
