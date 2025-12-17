package com.backendProject.Lovable_Clone.dto.subscription;

public record UsageTodayResponse(
    int tokenUsed,
    int tokenLimit,
    int previewsRunning,
    int previewsLimit
) {
}
