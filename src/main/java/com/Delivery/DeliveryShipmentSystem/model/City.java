package com.Delivery.DeliveryShipmentSystem.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double deliveryCost;


    @OneToMany(mappedBy = "city")
    private List<Shipment> shipments;

    // Constructors
    public City() {}
    public City(String name, Double deliveryCost) {
        this.name = name;
        this.deliveryCost = deliveryCost;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(Double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }
}