package com.cognizant.assignment.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Warehouse {

    @Id
    private UUID id;

    private String buildingName;
    private String address;
    private String zipcode;
    private String city;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "warhouse_id")
    private Set<Car> cars;


}
