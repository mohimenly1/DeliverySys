package com.Delivery.DeliveryShipmentSystem.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private LocalDateTime paidAt;

    @Enumerated(EnumType.STRING)
    private PaymentMethod method;

    @OneToOne
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;

    public Payment() {
        this.paidAt = LocalDateTime.now();
    }

    // Getters and Setters
    // ...
}