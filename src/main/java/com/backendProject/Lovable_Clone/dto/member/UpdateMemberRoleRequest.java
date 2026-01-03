package com.backendProject.Lovable_Clone.dto.member;

import com.backendProject.Lovable_Clone.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(
        @NotNull ProjectRole role
) {
}
