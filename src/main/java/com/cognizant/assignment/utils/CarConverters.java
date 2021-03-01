package com.cognizant.assignment.utils;

import com.cognizant.assignment.dtos.CarDetailDto;
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
            dto.setBrand(entity.getBrand());
            dto.setLicensed(entity.isLicensed());
            return dto;
        }
    }

    public static class CarDetailConverter {
        public static CarDetailDto toDto(Car entity) {
            CarDetailDto dto = new CarDetailDto();
            dto.setCarItem(CarListItemConverter.toDto(entity));
            dto.setBuildingName(entity.getWarehouse().getBuildingName());
            dto.setAddress(entity.getWarehouse().getAddress());
            dto.setCity(entity.getWarehouse().getCity());
            dto.setZipCode(entity.getWarehouse().getZipcode());
            return dto;
        }
    }
}
