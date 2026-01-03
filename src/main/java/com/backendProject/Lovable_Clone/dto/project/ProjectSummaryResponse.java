package com.backendProject.Lovable_Clone.dto.project;

import java.time.Instant;

public record ProjectSummaryResponse(
        Long id,
        String projectName,//String name--> String projectName
        Instant createdAt,
        Instant updatedAt
) {
}
