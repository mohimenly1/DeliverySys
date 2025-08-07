package com.Delivery.DeliveryShipmentSystem.mapper;

import com.Delivery.DeliveryShipmentSystem.dto.PaymentRequestDTO;
import com.Delivery.DeliveryShipmentSystem.dto.PaymentResponseDTO;
import com.Delivery.DeliveryShipmentSystem.model.Payment;

public class PaymentMapper {

    public static PaymentResponseDTO toDTO(Payment payment) {
        PaymentResponseDTO dto = new PaymentResponseDTO();
        dto.setId(payment.getId());
        dto.setAmount(payment.getAmount());
        dto.setStatus(payment.getStatus());

        if (payment.getShipment() != null) {
            dto.setShipmentId(payment.getShipment().getId());
        }

        return dto;
    }

    public static Payment toEntity(PaymentRequestDTO dto) {
        Payment payment = new Payment();
        payment.setAmount(dto.getAmount());
        payment.setStatus(dto.getStatus());

        return payment;
    }
}
