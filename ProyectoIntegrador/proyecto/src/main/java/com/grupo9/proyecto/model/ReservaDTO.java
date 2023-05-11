package com.grupo9.proyecto.model;

import java.sql.Date;

public class ReservaDTO {
    private Integer id;
    private Double horaDeComienzo;
    private Date fechaInicial;
    private Date fechaFinal;
    private Integer productoId;

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

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }
}
