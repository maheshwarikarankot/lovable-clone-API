package com.backendProject.Lovable_Clone.service;

import com.backendProject.Lovable_Clone.dto.subscription.CheckoutRequest;
import com.backendProject.Lovable_Clone.dto.subscription.CheckoutResponse;
import com.backendProject.Lovable_Clone.dto.subscription.PortalResponse;
import com.backendProject.Lovable_Clone.dto.subscription.SubscriptionResponse;
import org.jspecify.annotations.Nullable;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);
    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId);
    PortalResponse openCustomerPortal(Long userId);
}
