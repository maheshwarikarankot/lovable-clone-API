package com.backendProject.Lovable_Clone.dto.subscription;

public record UsageTodayResponse(
    Integer tokenUsed,
    Integer tokenLimit,
    Integer previewsRunning,
    Integer previewsLimit
) {
}
