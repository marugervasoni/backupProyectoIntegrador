package com.pi.dh.booking.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="products")
@Getter
@Setter
public class ProductsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="city_id")
    private CityEntity city;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="politic_id")
    private PoliticEntity politic;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ImageEntity> images;

    @ManyToOne
    @JoinColumn(name="categoryid")
        private CategoryEntity category;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="characteristic_id")
    private CharacteristicEntity characteristic;

    @Column(name = "title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="availability")
    private String availability;
}
