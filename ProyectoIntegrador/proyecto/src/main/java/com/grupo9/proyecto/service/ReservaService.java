package com.grupo9.proyecto.service;

import com.grupo9.proyecto.exceptions.ResourceNotFoundException;
import com.grupo9.proyecto.model.*;
import com.grupo9.proyecto.repository.IProductoRepository;
import com.grupo9.proyecto.repository.IReservaRepository;
import com.grupo9.proyecto.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ReservaService implements IReservaService{

    @Autowired
    private IReservaRepository reservaRepository;

    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;


    @Override
    public Reserva crearReserva(Reserva reserva) throws ResourceNotFoundException, ParseException {
        Producto producto = productoRepository.findById(reserva.getProducto().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));

        Usuario usuario = usuarioRepository.findById(reserva.getUsuario().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        reserva.setProducto(producto);
        reserva.setUsuario(usuario);

        Reserva reservaCreada = reservaRepository.save(reserva);

        producto.setReservaId(reservaCreada.getId());
        productoRepository.save(producto);

        return reservaCreada;
    }

    @Override
    public Reserva buscarReserva(Integer id) throws ResourceNotFoundException {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada"));
    }

    @Override
    public void cancelarReserva(Integer id) throws ResourceNotFoundException {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada"));
        reservaRepository.delete(reserva);
    }

    @Override
    public void actualizarReserva(Reserva reserva) throws ResourceNotFoundException {
        Reserva reservaExistente = reservaRepository.findById(reserva.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada con ID: " + reserva.getId()));

        // Actualizar atributos de la reserva existente con los valores de la reserva recibida
        reservaExistente.setHoraDeComienzo(reserva.getHoraDeComienzo());
        reservaExistente.setFechaInicial(reserva.getFechaInicial());
        reservaExistente.setFechaFinal(reserva.getFechaFinal());

        // Actualizar relaciones
        Producto producto = productoRepository.findById(reserva.getProducto().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con ID: " + reserva.getProducto().getId()));
        reservaExistente.setProducto(producto);

        Usuario usuario = usuarioRepository.findById(reserva.getUsuario().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: " + reserva.getUsuario().getId()));
        reservaExistente.setUsuario(usuario);

        reservaRepository.save(reservaExistente);
    }

    @Override
    public Set<Reserva> getTodos() {
        return new HashSet<>(reservaRepository.findAll());
    }

}

