package com.grupo9.proyecto.service;

import com.grupo9.proyecto.exceptions.ResourceNotFoundException;

import com.grupo9.proyecto.model.Reserva;

import java.text.ParseException;
import java.util.Set;

public interface IReservaService {

    Reserva crearReserva(Reserva reserva) throws ResourceNotFoundException, ParseException;
    Reserva buscarReserva (Integer id) throws ResourceNotFoundException;
    void cancelarReserva (Integer id) throws ResourceNotFoundException;
    void actualizarReserva(Reserva reserva) throws ResourceNotFoundException;
    Set<Reserva> getTodos();

}
