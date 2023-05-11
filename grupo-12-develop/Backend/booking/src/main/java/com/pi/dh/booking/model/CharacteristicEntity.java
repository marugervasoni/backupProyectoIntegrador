package com.pi.dh.booking.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="characteristic")
@Getter
@Setter
public class CharacteristicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "kitchen")
    private Boolean kitchen;

    @Column(name = "tv")
    private Boolean tv;

    @Column(name = "condition_air")
    private Boolean conditionAir;

    @Column(name = "pets_allowed")
    private Boolean petsAllowed;

    @Column(name = "free_parking")
    private Boolean freeParking;

    @Column(name = "pool")
    private Boolean pool;

    @Column(name = "wifi")
    private Boolean wifi;
}
