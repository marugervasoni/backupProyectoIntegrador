package com.pi.dh.booking.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "politics")
@Getter
@Setter
public class PoliticEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="rule_id")
    private RulesEntity rule;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="security_id")
    private SecurityEntity security;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cancellation_id")
    private CancellationEntity cancellation;
}
