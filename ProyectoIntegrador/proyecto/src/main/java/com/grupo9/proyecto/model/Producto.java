package com.grupo9.proyecto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String titulo;
    @Column(unique=true)
    private String nombre;
    private String descripcion;
    private String tipo;
    private Float rate;
    private String politicaCasa;
    private String politicaSalud;
    private String politicaCancelacion;

    @JsonIgnore
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<Reserva> reservas;

    @Column(name="reserva_id")
    private Integer reservaId;


    @OneToMany
    @JoinColumn(name = "id_producto")
    private List<Imagen> imagenes;


    @ManyToOne
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "caracteristica_id")
    private Caracteristica caracteristica;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


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

    public Producto() {
    }

    public Producto(Integer id, String titulo, String nombre, String descripcion, String tipo, Float rate, String politicaCasa, String politicaSalud, String politicaCancelacion, List<Reserva> reservas, Integer reservaId, List<Imagen> imagenes, Ciudad ciudad, Categoria categoria, Caracteristica caracteristica, Usuario usuario) {
        this.id = id;
        this.titulo = titulo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.rate = rate;
        this.politicaCasa = politicaCasa;
        this.politicaSalud = politicaSalud;
        this.politicaCancelacion = politicaCancelacion;
        this.reservas = reservas;
        this.reservaId = reservaId;
        this.imagenes = imagenes;
        this.ciudad = ciudad;
        this.categoria = categoria;
        this.caracteristica = caracteristica;
        this.usuario = usuario;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }


    public Integer getReservaId() {
        return reservaId;
    }

    public void setReservaId(Integer reservaId) {
        this.reservaId = reservaId;
    }

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(Caracteristica caracteristica) {
        this.caracteristica = caracteristica;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

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

    public void setRate(Float rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", tipo='" + tipo + '\'' +
                ", rate=" + rate +
                ", politicaCasa='" + politicaCasa + '\'' +
                ", politicaSalud='" + politicaSalud + '\'' +
                ", politicaCancelacion='" + politicaCancelacion + '\'' +
                ", reservas=" + reservas +
                ", reservaId=" + reservaId +
                ", imagenes=" + imagenes +
                ", ciudad=" + ciudad +
                ", categoria=" + categoria +
                ", caracteristica=" + caracteristica +
                ", usuario=" + usuario +
                '}';
    }
}
