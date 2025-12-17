package com.backendProject.Lovable_Clone.dto.subscription;

public record PlanLimitResponse(
    String planName,
    int maxTokensPerDay,
    int maxProjects,
    boolean unlimitedAi
) {
}
