package com.Delivery.DeliveryShipmentSystem.mapper;

import com.Delivery.DeliveryShipmentSystem.dto.*;
import com.Delivery.DeliveryShipmentSystem.model.*;

public class ShipmentMapper {


    public static Shipment toEntity(ShipmentRequestDTO dto, City city, Customer customer) {
        Shipment shipment = new Shipment();
        shipment.setTrackingCode(dto.getCode());
        shipment.setDescription(dto.getDescription());
        shipment.setCity(city);
        shipment.setCustomer(customer);
        return shipment;
    }


    public static ShipmentResponseDTO toDTO(Shipment shipment) {
        ShipmentResponseDTO dto = new ShipmentResponseDTO();
        dto.setId(shipment.getId());
        dto.setCode(shipment.getTrackingCode());
        dto.setDescription(shipment.getDescription());
        dto.setCityName(shipment.getCity().getName());
        dto.setDeliveryPrice(shipment.getCity().getDeliveryCost());
        dto.setCustomerName(shipment.getCustomer().getFullName());


        if (shipment.getStatus() != null) {
            dto.setShipmentStatus(shipment.getStatus().name());
        } else {
            dto.setShipmentStatus("UNKNOWN");
        }


        if (shipment.getPayment() != null) {
            dto.setPaymentAmount(shipment.getPayment().getAmount());

            dto.setPaymentStatus(shipment.getPayment().getStatus() != null ? shipment.getPayment().getStatus() : "UNKNOWN");
        } else {
            dto.setPaymentAmount(null);
            dto.setPaymentStatus("NOT PAID");
        }

        return dto;
    }

}
