package com.Delivery.DeliveryShipmentSystem.repository;

import com.Delivery.DeliveryShipmentSystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}
