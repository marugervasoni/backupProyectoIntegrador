package com.grupo9.proyecto.service;

import com.grupo9.proyecto.exceptions.ResourceNotFoundException;
import com.grupo9.proyecto.model.Categoria;
import com.grupo9.proyecto.model.CategoriaDTO;


import java.util.Set;

public interface ICategoriaService {
    Categoria crearCategoria(CategoriaDTO categoriaDTO);
    CategoriaDTO buscarCategoria (Integer id) throws ResourceNotFoundException;
    void actualizarCategoria (CategoriaDTO categoriaDTO);
    void eliminarCategoria (Integer id) throws ResourceNotFoundException;
    Set<CategoriaDTO> getTodos();
}
