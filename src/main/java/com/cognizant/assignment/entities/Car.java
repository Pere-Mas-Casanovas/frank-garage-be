package com.cognizant.assignment.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Car {

    @Id
    private UUID id;
    private Date acquisitionDate;
    private Date manufactureDate;
    private Double price;
    private String brand;
    private String model;
    @NotNull
    private String plateNumber;
}
