package com.backendProject.Lovable_Clone.entity;

import com.backendProject.Lovable_Clone.enums.SubscriptionStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class Subscription {

    private Long id;
    private User user;
    private Plan plan;

    private String stripeCustomerId;
    private String stripeSubscriptionId;

    private SubscriptionStatus status;

    private Instant currentPeriodStart;
    private Instant currentPeriodEnd;
    private Boolean cancelPeriodEnd = false;

    private Instant createdAt;
    private Instant updatedAt;
}
