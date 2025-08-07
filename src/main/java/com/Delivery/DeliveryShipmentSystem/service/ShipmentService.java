package com.Delivery.DeliveryShipmentSystem.service;

import com.Delivery.DeliveryShipmentSystem.dto.*;
import com.Delivery.DeliveryShipmentSystem.model.*;
import com.Delivery.DeliveryShipmentSystem.mapper.ShipmentMapper;
import com.Delivery.DeliveryShipmentSystem.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipmentService {

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public ShipmentResponseDTO createShipment(ShipmentRequestDTO requestDTO) {
        City city = cityRepository.findById(requestDTO.getCityId())
                .orElseThrow(() -> new RuntimeException("المدينة غير موجودة"));

        Customer customer = customerRepository.findById(requestDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("الزبون غير موجود"));

        Shipment shipment = ShipmentMapper.toEntity(requestDTO, city, customer);

        shipment = shipmentRepository.save(shipment);

        return ShipmentMapper.toDTO(shipment);
    }

    public List<ShipmentResponseDTO> getAllShipments() {
        return shipmentRepository.findAll()
                .stream()
                .map(ShipmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ShipmentResponseDTO getShipmentById(Long id) {
        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("الشحنة غير موجودة"));
        return ShipmentMapper.toDTO(shipment);
    }

    public void deleteShipment(Long id) {
        shipmentRepository.deleteById(id);
    }

    public ShipmentResponseDTO updateShipmentStatus(Long id, String status) {
        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("الشحنة غير موجودة"));

        try {
            ShipmentStatus newStatus = ShipmentStatus.valueOf(status);
            shipment.setStatus(newStatus);
            shipment = shipmentRepository.save(shipment);
            return ShipmentMapper.toDTO(shipment);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("حالة غير صالحة");
        }
    }


}