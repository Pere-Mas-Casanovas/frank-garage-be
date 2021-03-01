package com.cognizant.assignment.repositories;

import com.cognizant.assignment.entities.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CarRepository extends CrudRepository<Car, UUID> {
    public List<Car> findByPlateNumber(String plateNumber);
}
