package com.Delivery.DeliveryShipmentSystem.repository;

import com.Delivery.DeliveryShipmentSystem.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {}
