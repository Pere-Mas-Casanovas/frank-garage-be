package com.cognizant.assignment.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDetailDto implements Serializable {
    private CarListItemDto carItem;
    private String buildingName;
    private String address;
    private String zipCode;
    private String city;
}
