package com.backendProject.Lovable_Clone.dto.subscription;

public record PlanResponse(
        Long id,
        String name,
        String price,
        Integer maxProjects,
        Integer maxTokenPerDay,
        Boolean unlimitedAi
) {
}
