package com.grupo9.proyecto.service;

import com.grupo9.proyecto.exceptions.ResourceNotFoundException;
import com.grupo9.proyecto.model.Imagen;
import com.grupo9.proyecto.model.ImagenDTO;
import java.util.Set;

public interface IImagenService {

    Imagen crearImagen(ImagenDTO imagenDTO) throws ResourceNotFoundException;
    Imagen buscarImagenPorDTO(ImagenDTO imagenDTO);
    ImagenDTO buscarImagen (Integer id) throws ResourceNotFoundException;
    void actualizarImagen (ImagenDTO imagenDTO);
    void eliminarImagen (Integer id) throws ResourceNotFoundException;
    Set<ImagenDTO> getTodos();
}
