package com.Delivery.DeliveryShipmentSystem.service;

import com.Delivery.DeliveryShipmentSystem.dto.PaymentRequestDTO;
import com.Delivery.DeliveryShipmentSystem.dto.PaymentResponseDTO;
import com.Delivery.DeliveryShipmentSystem.model.Payment;
import com.Delivery.DeliveryShipmentSystem.model.Shipment;
import com.Delivery.DeliveryShipmentSystem.mapper.PaymentMapper;
import com.Delivery.DeliveryShipmentSystem.model.ShipmentStatus;
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
        System.out.println("=== Received payment request ===");
        System.out.println("Amount: " + dto.getAmount());
        System.out.println("Method: " + dto.getMethod());
        System.out.println("Shipment ID: " + dto.getShipmentId());

        Payment payment = PaymentMapper.toEntity(dto);

        if (dto.getShipmentId() != null) {
            Shipment shipment = shipmentRepository.findById(dto.getShipmentId()).orElse(null);
            if (shipment != null) {
                payment.setShipment(shipment);
                shipment.setStatus(ShipmentStatus.valueOf("PAID"));
                shipmentRepository.save(shipment);
            } else {
                System.out.println("Shipment not found!");
            }
        }

        Payment saved = paymentRepository.save(payment);
        System.out.println("Payment saved with ID: " + saved.getId());
        return PaymentMapper.toDTO(saved);
    }



    public PaymentResponseDTO getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .map(PaymentMapper::toDTO)
                .orElse(null);
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}