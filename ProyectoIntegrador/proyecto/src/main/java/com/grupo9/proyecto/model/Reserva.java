package com.grupo9.proyecto.model;


import jakarta.ejb.Local;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private Double horaDeComienzo;


    private Date fechaInicial;

    private Date fechaFinal;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getHoraDeComienzo() {
        return horaDeComienzo;
    }

    public void setHoraDeComienzo(Double horaDeComienzo) {
        this.horaDeComienzo = horaDeComienzo;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", horaDeComienzo=" + horaDeComienzo +
                ", fechaInicial=" + fechaInicial +
                ", fechaFinal=" + fechaFinal +
                ", producto=" + producto +
                ", usuario=" + usuario +
                '}';
    }
}
