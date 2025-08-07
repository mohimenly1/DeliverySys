package com.Delivery.DeliveryShipmentSystem.repository;

import com.Delivery.DeliveryShipmentSystem.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {}