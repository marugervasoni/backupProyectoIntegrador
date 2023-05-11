package com.pi.dh.booking.model;

import javax.persistence.*;

@Entity
@Table(name="role")
public class RolesEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;
}
