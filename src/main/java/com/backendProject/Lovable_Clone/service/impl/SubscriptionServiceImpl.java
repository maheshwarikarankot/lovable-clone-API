package com.backendProject.Lovable_Clone.service.impl;

import com.backendProject.Lovable_Clone.dto.subscription.CheckoutRequest;
import com.backendProject.Lovable_Clone.dto.subscription.CheckoutResponse;
import com.backendProject.Lovable_Clone.dto.subscription.PortalResponse;
import com.backendProject.Lovable_Clone.dto.subscription.SubscriptionResponse;
import com.backendProject.Lovable_Clone.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }

    @Override
    public CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}
