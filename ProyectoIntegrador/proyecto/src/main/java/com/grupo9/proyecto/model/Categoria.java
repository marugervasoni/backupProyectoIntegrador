package com.grupo9.proyecto.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String descripcion;
    private String urlImagenCategoria;



    public Categoria() {
    }

    public Categoria(Integer id, String titulo, String descripcion, String urlImagenCategoria) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImagenCategoria = urlImagenCategoria;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagenCategoria() {
        return urlImagenCategoria;
    }

    public void setUrlImagenCategoria(String urlImagenCategoria) {
        this.urlImagenCategoria = urlImagenCategoria;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", urlImagenCategoria='" + urlImagenCategoria + '\'' +
                '}';
    }
}
