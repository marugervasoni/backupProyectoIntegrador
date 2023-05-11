package com.grupo9.proyecto.model;

import jakarta.persistence.*;

@Entity
@Table(name="Rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descripcion;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    @Override
    public String toString() {
        return "Rol{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}


