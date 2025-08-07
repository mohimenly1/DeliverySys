package com.Delivery.DeliveryShipmentSystem.service;

import com.Delivery.DeliveryShipmentSystem.dto.CustomerRequestDTO;
import com.Delivery.DeliveryShipmentSystem.dto.CustomerResponseDTO;
import com.Delivery.DeliveryShipmentSystem.model.Customer;
import com.Delivery.DeliveryShipmentSystem.mapper.CustomerMapper;
import com.Delivery.DeliveryShipmentSystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerResponseDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(CustomerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CustomerResponseDTO createCustomer(CustomerRequestDTO dto) {
        Customer customer = CustomerMapper.toEntity(dto);
        return CustomerMapper.toDTO(customerRepository.save(customer));
    }

    public CustomerResponseDTO getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(CustomerMapper::toDTO)
                .orElse(null);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
