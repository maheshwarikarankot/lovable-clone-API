package com.backendProject.Lovable_Clone.service;

import com.backendProject.Lovable_Clone.dto.subscription.PlanLimitResponse;
import com.backendProject.Lovable_Clone.dto.subscription.UsageTodayResponse;
import org.jspecify.annotations.Nullable;

public interface UsageService {
    UsageTodayResponse getTodayUsageOfUser(Long userId);
    PlanLimitResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}
