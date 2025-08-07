package com.Delivery.DeliveryShipmentSystem.mapper;

import com.Delivery.DeliveryShipmentSystem.dto.CityRequestDTO;
import com.Delivery.DeliveryShipmentSystem.dto.CityResponseDTO;
import com.Delivery.DeliveryShipmentSystem.model.City;

public class CityMapper {

    public static CityResponseDTO toDTO(City city) {
        CityResponseDTO dto = new CityResponseDTO();
        dto.setId(city.getId());
        dto.setName(city.getName());
        dto.setDeliveryCost(city.getDeliveryCost());
        return dto;
    }

    public static City toEntity(CityRequestDTO dto) {
        City city = new City();
        city.setName(dto.getName());
        city.setDeliveryCost(dto.getDeliveryCost());
        return city;
    }
}
