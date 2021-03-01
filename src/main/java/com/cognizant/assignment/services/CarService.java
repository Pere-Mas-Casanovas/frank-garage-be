package com.cognizant.assignment.services;

import com.cognizant.assignment.dtos.CarDetailDto;
import com.cognizant.assignment.dtos.CarListItemDto;
import com.cognizant.assignment.entities.Car;
import com.cognizant.assignment.repositories.CarRepository;
import com.cognizant.assignment.utils.CarConverters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.cognizant.assignment.utils.CarConverters.*;

@Component
public class CarService {

    @Autowired
    private CarRepository repository;

    public List<CarListItemDto> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(),false)
                .map(CarListItemConverter::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public CarDetailDto getCarDetail(String plateNumber) {
        return repository.findByPlateNumber(plateNumber).stream()
                .findFirst()
                .map(CarDetailConverter::toDto)
                .orElseThrow(IllegalArgumentException::new);
    }
}
