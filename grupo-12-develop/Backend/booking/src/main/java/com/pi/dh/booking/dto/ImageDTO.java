package com.pi.dh.booking.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class ImageDTO {

    private Integer id;
    private String title;
    private String url;
}
