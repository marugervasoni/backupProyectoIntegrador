package com.pi.dh.booking.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class PoliticDTO {

    private Integer id;
    private RulesDTO rule;
    private SecurityDTO security;
    private CancellationDTO cancellation;
}
