package com.grupo9.proyecto.model;


import jakarta.persistence.*;

@Entity
@Table
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String url;


    public Imagen() {
    }

    public Imagen(Integer id, String titulo, String url, Producto producto) {
        this.id = id;
        this.titulo = titulo;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    @Override
    public String toString() {
        return "Imagen{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
