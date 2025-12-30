package com.backendProject.Lovable_Clone.service.impl;

import com.backendProject.Lovable_Clone.dto.subscription.PlanLimitResponse;
import com.backendProject.Lovable_Clone.dto.subscription.UsageTodayResponse;
import com.backendProject.Lovable_Clone.service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitResponse getCurrentSubscriptionLimitsOfUser(Long userId) {
        return null;
    }
}
