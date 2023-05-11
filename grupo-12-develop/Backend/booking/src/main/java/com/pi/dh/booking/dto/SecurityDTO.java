package com.pi.dh.booking.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class SecurityDTO {

    private int id;
    private String title;
    private String description;
}
