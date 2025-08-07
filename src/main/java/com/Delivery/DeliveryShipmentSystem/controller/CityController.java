package com.Delivery.DeliveryShipmentSystem.controller;

import com.Delivery.DeliveryShipmentSystem.dto.CityRequestDTO;
import com.Delivery.DeliveryShipmentSystem.dto.CityResponseDTO;
import com.Delivery.DeliveryShipmentSystem.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public List<CityResponseDTO> getAllCities() {
        return cityService.getAllCities();
    }

    @PostMapping
    public CityResponseDTO createCity(@RequestBody CityRequestDTO dto) {
        return cityService.createCity(dto);
    }

    @GetMapping("/{id}")
    public CityResponseDTO getCityById(@PathVariable Long id) {
        return cityService.getCityById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
    }
}
