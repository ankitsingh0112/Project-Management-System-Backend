package com.ankit.repository;

import com.ankit.modal.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepo extends JpaRepository<Subscription, Long> {
    Subscription findByUserId(Long userId);
}
