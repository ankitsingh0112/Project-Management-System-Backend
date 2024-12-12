package com.ankit.service;

import com.ankit.modal.PlanType;
import com.ankit.modal.Subscription;
import com.ankit.modal.User;

public interface SubscriptionService {
    Subscription createSubscription(User user);
    Subscription getUsersSubscription(Long userId) throws Exception;
    Subscription upgradeSubscription(Long userId, PlanType planType);
    boolean isValid(Subscription subscription);
}
