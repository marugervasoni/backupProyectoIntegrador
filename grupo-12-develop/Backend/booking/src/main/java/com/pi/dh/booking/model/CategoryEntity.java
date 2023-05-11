package com.pi.dh.booking.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *  model for representation  table categories DB
 * 
 *  @author  Cesar Gutierrez, Alejandro Alonso
 *  @version 1.0
 *  @since 1.0
 */

@Data
@NoArgsConstructor
@Entity
@Table(name="categories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="categoryid")
    private Integer id;

    @Column(name="title")
    @NotNull
    private String title;

    @Column(name="description")
    @NotNull
    private String description;

    @Column(name="image_url")
    @NotNull
    private String imageUrl;
    
}
