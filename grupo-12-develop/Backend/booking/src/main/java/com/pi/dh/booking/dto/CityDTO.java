package com.pi.dh.booking.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class CityDTO {

    private Integer id;
    private String name;
    private CountryDTO country;
}
