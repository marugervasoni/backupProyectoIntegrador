package com.grupo9.proyecto.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo9.proyecto.exceptions.ResourceNotFoundException;
import com.grupo9.proyecto.model.*;
import com.grupo9.proyecto.repository.IImagenRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ImagenService implements IImagenService{
    @Autowired
    private IImagenRepository imagenRepository;


    private static final org.apache.log4j.Logger logger = Logger.getLogger(ImagenService.class);

    @Autowired
    ObjectMapper mapper;

    @Override
    public Imagen crearImagen(ImagenDTO imagenDTO) throws ResourceNotFoundException {
        Imagen imagen = mapper.convertValue(imagenDTO, Imagen.class);

        logger.info("Se creo la Imagen = " + imagenDTO.getTitulo() + "-" + imagenDTO.getUrl());
        return imagenRepository.save(imagen);
    }

    @Override
    public Imagen buscarImagenPorDTO(ImagenDTO imagenDTO) {
        Imagen imagen = imagenRepository.findById(imagenDTO.getId()).orElse(null);
        if (imagen == null) {
            throw new RuntimeException("No se encontró la imagen con el id " + imagenDTO.getId());
        }
        return imagen;
    }

    @Override
    public ImagenDTO buscarImagen(Integer id) {
        Optional<Imagen> imagen = imagenRepository.findById(id);
        ImagenDTO imagenDTO = null;
        if (imagen.isPresent())
            imagenDTO = mapper.convertValue(imagen, ImagenDTO.class);
        logger.info("Se encontro la Imagen = " + imagenDTO.getTitulo() + "-" + imagenDTO.getUrl());
        return imagenDTO;
    }

    @Override
    public void actualizarImagen(ImagenDTO imagenDTO) {
        Imagen imagen = mapper.convertValue(imagenDTO, Imagen.class);
        imagenRepository.save(imagen);
        logger.info("Se cambio la Imagen = " + imagenDTO.getId());
    }

    @Override
    public void eliminarImagen(Integer id) throws ResourceNotFoundException {
        if (buscarImagen(id) == null)
            throw new ResourceNotFoundException("No existe la Imagen con el id " + id);
        logger.info("Se elimino la Imagen = " + id);
        imagenRepository.deleteById(id);
    }

    @Override
    public Set<ImagenDTO> getTodos() {
        List<Imagen> imagens = imagenRepository.findAll();
        Set<ImagenDTO> imagensDTO = new HashSet<>();
        for (Imagen imagen : imagens){
            imagensDTO.add(mapper.convertValue(imagen, ImagenDTO.class));
        }
        return imagensDTO;
    }
}