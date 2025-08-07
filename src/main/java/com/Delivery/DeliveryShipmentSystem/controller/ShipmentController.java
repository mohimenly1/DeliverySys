package com.Delivery.DeliveryShipmentSystem.controller;

import com.Delivery.DeliveryShipmentSystem.dto.ShipmentRequestDTO;
import com.Delivery.DeliveryShipmentSystem.dto.ShipmentResponseDTO;
import com.Delivery.DeliveryShipmentSystem.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {

    @Autowired
    private ShipmentService shipmentService;

    @GetMapping
    public List<ShipmentResponseDTO> getAllShipments() {
        return shipmentService.getAllShipments();
    }

    @PostMapping
    public ShipmentResponseDTO createShipment(@RequestBody ShipmentRequestDTO dto) {
        return shipmentService.createShipment(dto);
    }

    @GetMapping("/{id}")
    public ShipmentResponseDTO getShipmentById(@PathVariable Long id) {
        return shipmentService.getShipmentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteShipment(@PathVariable Long id) {
        shipmentService.deleteShipment(id);
    }
}
