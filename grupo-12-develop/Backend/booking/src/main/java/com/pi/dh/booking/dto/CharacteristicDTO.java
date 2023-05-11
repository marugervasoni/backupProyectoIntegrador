package com.pi.dh.booking.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class CharacteristicDTO {

    private Integer id;
    private Boolean kitchen;
    private Boolean tv;
    private Boolean conditionAir;
    private Boolean petsAllowed;
    private Boolean freeParking;
    private Boolean pool;
    private Boolean wifi;
}
