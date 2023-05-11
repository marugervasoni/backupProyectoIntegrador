package com.grupo9.proyecto.model;

import java.util.Set;

public class CaracteristicaDTO {
    private Integer id;
    private Boolean aireAcondicionado;
    private Boolean estacionamientoGratuito;
    private Boolean wiFi;
    private Boolean television;
    private Boolean aptoMascotas;

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
        return "CaracteristicaDTO{" +
                "id=" + id +
                ", aireAcondicionado=" + aireAcondicionado +
                ", estacionamientoGratuito=" + estacionamientoGratuito +
                ", wiFi=" + wiFi +
                ", television=" + television +
                ", aptoMascotas=" + aptoMascotas +
                '}';
    }
}
