package com.grupo9.proyecto.service;

import com.grupo9.proyecto.exceptions.ResourceNotFoundException;
import com.grupo9.proyecto.model.Caracteristica;
import com.grupo9.proyecto.model.CaracteristicaDTO;

import java.util.Set;

public interface ICaracteristicaService {
    Caracteristica crearCaracteristica(CaracteristicaDTO caracteristicaDTO);
    CaracteristicaDTO buscarCaracteristica (Integer id) throws ResourceNotFoundException;
    void actualizarCaracteristica (CaracteristicaDTO caracteristicaDTO);
    void eliminarCaracteristica (Integer id) throws ResourceNotFoundException;
    Set<CaracteristicaDTO> getTodos();
}
