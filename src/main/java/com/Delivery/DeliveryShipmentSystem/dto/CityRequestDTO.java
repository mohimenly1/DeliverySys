package com.Delivery.DeliveryShipmentSystem.dto;

public class CityRequestDTO {
    private String name;
    private Double deliveryCost;

    // getters and setters
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
