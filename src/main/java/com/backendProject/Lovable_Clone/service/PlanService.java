package com.backendProject.Lovable_Clone.service;

import com.backendProject.Lovable_Clone.dto.subscription.PlanResponse;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface PlanService {
    List<PlanResponse> getAllActivePlans();
}
