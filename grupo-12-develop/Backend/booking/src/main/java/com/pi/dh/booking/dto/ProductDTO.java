package com.pi.dh.booking.dto;

import com.pi.dh.booking.model.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
public class ProductDTO {

    private Integer id;
    private CityDTO city;
    private PoliticDTO politic;
    private List<ImageDTO> images;
    private CategoryDTO category;
    private CharacteristicDTO characteristic;
    private String title;
    private String description;
    private String availability;
}
