package com.Delivery.DeliveryShipmentSystem.controller;

import com.Delivery.DeliveryShipmentSystem.dto.CustomerRequestDTO;
import com.Delivery.DeliveryShipmentSystem.dto.CustomerResponseDTO;
import com.Delivery.DeliveryShipmentSystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<CustomerResponseDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public CustomerResponseDTO createCustomer(@RequestBody CustomerRequestDTO dto) {
        return customerService.createCustomer(dto);
    }

    @GetMapping("/{id}")
    public CustomerResponseDTO getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}
