package com.grupo9.proyecto.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class ProductoDTO {
    private Integer id;
    private String titulo;
    private String nombre;
    private String descripcion;
    private String tipo;
    private Float rate;
    private CiudadDTO ciudad;
    private CategoriaDTO categoria;
    private CaracteristicaDTO caracteristica;
    private UsuarioDTO usuario;
    private List<ImagenDTO> imagenes;
    private String politicaCasa;
    private String politicaSalud;
    private String politicaCancelacion;
    @ElementCollection
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private List<Date> fechasDisponibles;
    private List<ReservaDTO> reservas;




    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getRate() {
        return rate;
    }

    public String getPoliticaCasa() {
        return politicaCasa;
    }

    public void setPoliticaCasa(String politicaCasa) {
        this.politicaCasa = politicaCasa;
    }

    public String getPoliticaSalud() {
        return politicaSalud;
    }

    public void setPoliticaSalud(String politicaSalud) {
        this.politicaSalud = politicaSalud;
    }

    public String getPoliticaCancelacion() {
        return politicaCancelacion;
    }

    public void setPoliticaCancelacion(String politicaCancelacion) {
        this.politicaCancelacion = politicaCancelacion;
    }

    public List<ImagenDTO> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<ImagenDTO> imagenes) {
        this.imagenes = imagenes;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public CiudadDTO getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadDTO ciudad) {
        this.ciudad = ciudad;
    }

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }

    public CaracteristicaDTO getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(CaracteristicaDTO caracteristica) {
        this.caracteristica = caracteristica;
    }

    public Integer getId() {
        return id;
    }

    public List<ReservaDTO> getReservas() {
        return reservas;
    }

    public void setReservas(List<ReservaDTO> reservas) {
        this.reservas = reservas;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Date> getFechasDisponibles() {
        return fechasDisponibles;
    }

    public void setFechasDisponibles(List<Date> fechasDisponibles) {
        this.fechasDisponibles = fechasDisponibles;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    @Override
    public String toString() {
        return "ProductoDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", tipo='" + tipo + '\'' +
                ", rate=" + rate +
                ", ciudad=" + ciudad +
                ", categoria=" + categoria +
                ", caracteristica=" + caracteristica +
                ", usuario=" + usuario +
                ", imagenes=" + imagenes +
                ", fechasDisponibles=" + fechasDisponibles +
                ", reservas=" + reservas +
                '}';
    }
}