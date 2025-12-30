package com.backendProject.Lovable_Clone.dto.subscription;

public record PlanLimitResponse(
    String planName,
    Integer maxTokensPerDay,
    Integer maxProjects,
    Boolean unlimitedAi
) {
}
