package com.grupo9.proyecto.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="caracteristica_producto")
public class Caracteristica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean aireAcondicionado;
    private Boolean estacionamientoGratuito;
    private Boolean wiFi;
    private Boolean television;
    private Boolean aptoMascotas;



    public Caracteristica() {
    }

    public Caracteristica(Integer id, Boolean aireAcondicionado, Boolean estacionamientoGratuito, Boolean wiFi, Boolean television, Boolean aptoMascotas, Producto producto) {
        this.id = id;
        this.aireAcondicionado = aireAcondicionado;
        this.estacionamientoGratuito = estacionamientoGratuito;
        this.wiFi = wiFi;
        this.television = television;
        this.aptoMascotas = aptoMascotas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(Boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public Boolean getEstacionamientoGratuito() {
        return estacionamientoGratuito;
    }

    public void setEstacionamientoGratuito(Boolean estacionamientoGratuito) {
        this.estacionamientoGratuito = estacionamientoGratuito;
    }

    public Boolean getWiFi() {
        return wiFi;
    }

    public void setWiFi(Boolean wiFi) {
        this.wiFi = wiFi;
    }

    public Boolean getTelevision() {
        return television;
    }

    public void setTelevision(Boolean television) {
        this.television = television;
    }

    public Boolean getAptoMascotas() {
        return aptoMascotas;
    }

    public void setAptoMascotas(Boolean aptoMascotas) {
        this.aptoMascotas = aptoMascotas;
    }



    @Override
    public String toString() {
        return "Caracteristica{" +
                "id=" + id +
                ", aireAcondicionado=" + aireAcondicionado +
                ", estacionamientoGratuito=" + estacionamientoGratuito +
                ", wiFi=" + wiFi +
                ", television=" + television +
                ", aptoMascotas=" + aptoMascotas +
                '}';
    }
}
