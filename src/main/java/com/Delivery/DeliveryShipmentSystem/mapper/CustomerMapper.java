package com.Delivery.DeliveryShipmentSystem.mapper;

import com.Delivery.DeliveryShipmentSystem.dto.CustomerRequestDTO;
import com.Delivery.DeliveryShipmentSystem.dto.CustomerResponseDTO;
import com.Delivery.DeliveryShipmentSystem.model.Customer;

public class CustomerMapper {

    public static CustomerResponseDTO toDTO(Customer customer) {
        CustomerResponseDTO dto = new CustomerResponseDTO();
        dto.setId(customer.getId());
        dto.setFullName(customer.getFullName());
        dto.setPhone(customer.getPhone());
        return dto;
    }

    public static Customer toEntity(CustomerRequestDTO dto) {
        Customer customer = new Customer();
        customer.setFullName(dto.getFullName());
        customer.setPhone(dto.getPhone());
        return customer;
    }
}
