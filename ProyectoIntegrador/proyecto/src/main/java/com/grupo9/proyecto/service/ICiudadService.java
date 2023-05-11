package com.grupo9.proyecto.service;


import com.grupo9.proyecto.exceptions.ResourceNotFoundException;
import com.grupo9.proyecto.model.Ciudad;
import com.grupo9.proyecto.model.CiudadDTO;


import java.util.Set;

public interface ICiudadService {
    Ciudad crearCiudad(CiudadDTO ciudadDTO);
    CiudadDTO buscarCiudad (Integer id) throws ResourceNotFoundException;
    void actualizarCiudad (CiudadDTO ciudadDTO);
    void eliminarCiudad (Integer id) throws ResourceNotFoundException;
    Set<CiudadDTO> getTodos();

}
