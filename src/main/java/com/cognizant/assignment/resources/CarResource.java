package com.cognizant.assignment.resources;

import com.cognizant.assignment.dtos.CarDetailDto;
import com.cognizant.assignment.dtos.CarListItemDto;
import com.cognizant.assignment.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/car")
public class CarResource {

    @Autowired
    private CarService service;

    @GetMapping("/list")
    public ResponseEntity<List<CarListItemDto>> listCars() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/detail/{plateNumber}")
    public ResponseEntity<CarDetailDto> detail(@PathVariable("plateNumber") String plateNumber) {
        return new ResponseEntity<>(service.getCarDetail(plateNumber), HttpStatus.OK);
    }
}
