package com.cognizant.assignment.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarListItemDto implements Serializable {
    private UUID id;
    private String plateNumber;
    private String brand;
    private String model;
    private Double price;
    private Date acquisitionDate;
    private Date manufactureDate;
    private boolean licensed;
}
