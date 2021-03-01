package com.cognizant.assignment.utils;

import com.cognizant.assignment.dtos.CarListItemDto;
import com.cognizant.assignment.entities.Car;

public class CarConverters {

    public static class CarListItemConverter {
        public static CarListItemDto toDto(Car entity) {
            CarListItemDto dto = new CarListItemDto();
            dto.setId(entity.getId());
            dto.setModel(entity.getModel());
            dto.setAcquisitionDate(entity.getAcquisitionDate());
            dto.setPlateNumber(entity.getPlateNumber());
            dto.setManufactureDate(entity.getManufactureDate());
            dto.setPrice(entity.getPrice());
            return dto;
        }
    }
}
