package com.Delivery.DeliveryShipmentSystem.controller;

import com.Delivery.DeliveryShipmentSystem.dto.PaymentRequestDTO;
import com.Delivery.DeliveryShipmentSystem.dto.PaymentResponseDTO;
import com.Delivery.DeliveryShipmentSystem.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public List<PaymentResponseDTO> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @PostMapping
    public PaymentResponseDTO createPayment(@RequestBody PaymentRequestDTO dto) {
        return paymentService.createPayment(dto);
    }

    @GetMapping("/{id}")
    public PaymentResponseDTO getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
    }
}
