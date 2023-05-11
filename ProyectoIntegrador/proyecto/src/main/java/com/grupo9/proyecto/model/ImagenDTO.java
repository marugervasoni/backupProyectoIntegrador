package com.grupo9.proyecto.model;

public class ImagenDTO {
    private Integer id;
    private String titulo;
    private String url;



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
        return "ImagenDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
