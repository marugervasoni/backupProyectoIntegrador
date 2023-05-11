package com.grupo9.proyecto.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo9.proyecto.exceptions.ResourceNotFoundException;
import com.grupo9.proyecto.model.Categoria;
import com.grupo9.proyecto.model.CategoriaDTO;
import com.grupo9.proyecto.repository.ICategoriaRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CategoriaService implements ICategoriaService {
    @Autowired
    private ICategoriaRepository categoriaRepository;

    private static final org.apache.log4j.Logger logger = Logger.getLogger(CategoriaService.class);

    @Autowired
    ObjectMapper mapper;

    @Override
    public Categoria crearCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = null;

        if (categoriaDTO.getId() != null) {
            categoria = categoriaRepository.findById(categoriaDTO.getId()).orElse(null);
        }

        if (categoria == null) {
            categoria = mapper.convertValue(categoriaDTO, Categoria.class);
            logger.info("Se creó la Categoría = " + categoriaDTO.getTitulo());
            categoria = categoriaRepository.save(categoria);
        }

        return categoria;
    }

    @Override
    public CategoriaDTO buscarCategoria(Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        CategoriaDTO categoriaDTO = null;
        if (categoria.isPresent())
            categoriaDTO = mapper.convertValue(categoria, CategoriaDTO.class);
        logger.info("Se encontro la Categoria = " + categoriaDTO.getTitulo());
        return categoriaDTO;
    }

    @Override
    public void actualizarCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = mapper.convertValue(categoriaDTO, Categoria.class);
        categoriaRepository.save(categoria);
        logger.info("Se cambio la Categoria = " + categoriaDTO.getId());
    }

    @Override
    public void eliminarCategoria(Integer id) throws ResourceNotFoundException {
        if (buscarCategoria(id) == null)
            throw new ResourceNotFoundException("No existe la Categoria con el id " + id);
        logger.info("Se elimino la Categoria = " + id);
        categoriaRepository.deleteById(id);
    }

    @Override
    public Set<CategoriaDTO> getTodos() {
        List<Categoria> categorias = categoriaRepository.findAll();
        Set<CategoriaDTO> categoriasDTO = new HashSet<>();
        for (Categoria categoria : categorias){
            categoriasDTO.add(mapper.convertValue(categoria, CategoriaDTO.class));
        }
        return categoriasDTO;
    }
}