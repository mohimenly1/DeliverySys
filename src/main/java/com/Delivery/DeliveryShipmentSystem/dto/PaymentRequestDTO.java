package com.Delivery.DeliveryShipmentSystem.dto;

import com.Delivery.DeliveryShipmentSystem.model.PaymentMethod;

public class PaymentRequestDTO {
    private Double amount;
    private String status;
    private Long shipmentId;
    private PaymentMethod method; // جديد

    // Getters & Setters
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Long getShipmentId() { return shipmentId; }
    public void setShipmentId(Long shipmentId) { this.shipmentId = shipmentId; }

    public PaymentMethod getMethod() { return method; }
    public void setMethod(PaymentMethod method) { this.method = method; }
}
