package com.grupo9.proyecto.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo9.proyecto.exceptions.ResourceNotFoundException;
import com.grupo9.proyecto.model.Ciudad;
import com.grupo9.proyecto.model.CiudadDTO;
import com.grupo9.proyecto.repository.ICiudadRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CiudadService implements ICiudadService {
    @Autowired
    private ICiudadRepository ciudadRepository;

    private static final org.apache.log4j.Logger logger = Logger.getLogger(CiudadService.class);

    @Autowired
    ObjectMapper mapper;


    @Override
    public Ciudad crearCiudad(CiudadDTO ciudadDTO) {
        Ciudad ciudad = null;

        if (ciudadDTO.getId() != null) {
            ciudad = ciudadRepository.findById(ciudadDTO.getId()).orElse(null);
        }

        if (ciudad == null) {
            ciudad = mapper.convertValue(ciudadDTO, Ciudad.class);
            logger.info("Se creo la Ciudad = " + ciudadDTO.getNombre() + "-" + ciudadDTO.getProvincia());
            ciudad = ciudadRepository.save(ciudad);
        }

        return ciudad;
    }

    @Override
    public CiudadDTO buscarCiudad(Integer id) {
        Optional<Ciudad> ciudad = ciudadRepository.findById(id);
        CiudadDTO ciudadDTO = null;
        if (ciudad.isPresent())
            ciudadDTO = mapper.convertValue(ciudad, CiudadDTO.class);
        logger.info("Se encontro la Imagen = " + ciudadDTO.getNombre() + "-" + ciudadDTO.getProvincia());
        return ciudadDTO;
    }

    @Override
    public void actualizarCiudad(CiudadDTO ciudadDTO) {
        Ciudad ciudad = mapper.convertValue(ciudadDTO, Ciudad.class);
        ciudadRepository.save(ciudad);
        logger.info("Se cambio la Ciudad = " + ciudadDTO.getId());
    }

    @Override
    public void eliminarCiudad(Integer id) throws ResourceNotFoundException {
        if (buscarCiudad(id) == null)
            throw new ResourceNotFoundException("No existe la Ciudad con el id " + id);
        logger.info("Se elimino la Ciudad = " + id);
        ciudadRepository.deleteById(id);
    }

    @Override
    public Set<CiudadDTO> getTodos() {
        List<Ciudad> ciudades = ciudadRepository.findAll();
        Set<CiudadDTO> ciudadesDTO = new HashSet<>();
        for (Ciudad ciudad : ciudades){
            ciudadesDTO.add(mapper.convertValue(ciudad, CiudadDTO.class));
        }
        return ciudadesDTO;
    }
}