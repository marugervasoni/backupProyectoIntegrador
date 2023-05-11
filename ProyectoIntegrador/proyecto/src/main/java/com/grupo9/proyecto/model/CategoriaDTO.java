package com.grupo9.proyecto.model;

import java.util.List;

public class CategoriaDTO {
    private Integer id;
    private String titulo;
    private String descripcion;
    private String urlImagenCategoria;



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
        return "CategoriaDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", urlImagenCategoria='" + urlImagenCategoria + '\'' +
                '}';
    }
}
