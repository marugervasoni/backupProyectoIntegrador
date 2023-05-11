package com.pi.dh.booking.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="reservation")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="hour_reservation")
    private String hour;

    @Column(name="start_date_reservation")
    private Date startDate;

    @Column(name="end_date_reservation")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name="products_id")
    private ProductsEntity products;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ProductsEntity getProducts() {
        return products;
    }

    public void setProducts(ProductsEntity products) {
        this.products = products;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}

