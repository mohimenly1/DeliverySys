package com.Delivery.DeliveryShipmentSystem.mapper;

import com.Delivery.DeliveryShipmentSystem.dto.*;
import com.Delivery.DeliveryShipmentSystem.model.*;

public class ShipmentMapper {

    public static Shipment toEntity(ShipmentRequestDTO dto, City city, Customer customer) {
        Shipment shipment = new Shipment();
        shipment.setTrackingCode(dto.getCode());  // استخدم setTrackingCode بدلاً من setCode
        shipment.setDescription(dto.getDescription());
        shipment.setCity(city);
        shipment.setCustomer(customer);
        return shipment;
    }

    public static ShipmentResponseDTO toDTO(Shipment shipment) {
        ShipmentResponseDTO dto = new ShipmentResponseDTO();
        dto.setId(shipment.getId());
        dto.setCode(shipment.getTrackingCode());  // استخدم getTrackingCode
        dto.setDescription(shipment.getDescription());
        dto.setCityName(shipment.getCity().getName());
        dto.setCustomerName(shipment.getCustomer().getFullName());
        return dto;
    }

}