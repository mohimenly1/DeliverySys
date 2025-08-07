package com.Delivery.DeliveryShipmentSystem.service;

import com.Delivery.DeliveryShipmentSystem.dto.PaymentRequestDTO;
import com.Delivery.DeliveryShipmentSystem.dto.PaymentResponseDTO;
import com.Delivery.DeliveryShipmentSystem.model.Payment;
import com.Delivery.DeliveryShipmentSystem.model.Shipment;
import com.Delivery.DeliveryShipmentSystem.mapper.PaymentMapper;
import com.Delivery.DeliveryShipmentSystem.repository.PaymentRepository;
import com.Delivery.DeliveryShipmentSystem.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ShipmentRepository shipmentRepository;

    public List<PaymentResponseDTO> getAllPayments() {
        return paymentRepository.findAll().stream()
                .map(PaymentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PaymentResponseDTO createPayment(PaymentRequestDTO dto) {
        Payment payment = PaymentMapper.toEntity(dto);

        if (dto.getShipmentId() != null) {
            Shipment shipment = shipmentRepository.findById(dto.getShipmentId()).orElse(null);
            payment.setShipment(shipment);
        }

        return PaymentMapper.toDTO(paymentRepository.save(payment));
    }

    public PaymentResponseDTO getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .map(PaymentMapper::toResponseDTO)
                .orElse(null);
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}