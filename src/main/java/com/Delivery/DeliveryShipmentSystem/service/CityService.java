package com.Delivery.DeliveryShipmentSystem.service;

import com.Delivery.DeliveryShipmentSystem.dto.CityRequestDTO;
import com.Delivery.DeliveryShipmentSystem.dto.CityResponseDTO;
import com.Delivery.DeliveryShipmentSystem.model.City;
import com.Delivery.DeliveryShipmentSystem.mapper.CityMapper;
import com.Delivery.DeliveryShipmentSystem.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<CityResponseDTO> getAllCities() {
        return cityRepository.findAll().stream()
                .map(CityMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CityResponseDTO createCity(CityRequestDTO dto) {
        City city = CityMapper.toEntity(dto);
        return CityMapper.toDTO(cityRepository.save(city));
    }

    public CityResponseDTO getCityById(Long id) {
        return cityRepository.findById(id)
                .map(CityMapper::toDTO)
                .orElse(null);
    }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }
}
