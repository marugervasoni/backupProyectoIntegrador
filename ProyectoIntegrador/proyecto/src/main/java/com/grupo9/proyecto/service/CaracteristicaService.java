package com.grupo9.proyecto.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo9.proyecto.exceptions.ResourceNotFoundException;
import com.grupo9.proyecto.model.Caracteristica;
import com.grupo9.proyecto.model.CaracteristicaDTO;
import com.grupo9.proyecto.model.Categoria;
import com.grupo9.proyecto.model.CategoriaDTO;
import com.grupo9.proyecto.repository.ICaracteristicaRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CaracteristicaService  implements  ICaracteristicaService{
    @Autowired
    private ICaracteristicaRepository caracteristicaRepository;

    private static final org.apache.log4j.Logger logger = Logger.getLogger(CaracteristicaService.class);

    @Autowired
    ObjectMapper mapper;

    @Override
    public Caracteristica crearCaracteristica(CaracteristicaDTO caracteristicaDTO) {
        Caracteristica caracteristica = mapper.convertValue(caracteristicaDTO, Caracteristica.class);
        logger.info("Se creo la Caracteristica = " + caracteristicaDTO.getId());
        return caracteristicaRepository.save(caracteristica);
    }

    @Override
    public CaracteristicaDTO buscarCaracteristica(Integer id) {
        Optional<Caracteristica> caracteristica = caracteristicaRepository.findById(id);
        CaracteristicaDTO caracteristicaDTO = null;
        if (caracteristica.isPresent())
            caracteristicaDTO = mapper.convertValue(caracteristica, CaracteristicaDTO.class);
        logger.info("Se encontro la Caracteristica = " + caracteristicaDTO.getId());
        return caracteristicaDTO;
    }

    @Override
    public void actualizarCaracteristica(CaracteristicaDTO caracteristicaDTO) {
        Caracteristica caracteristica = mapper.convertValue(caracteristicaDTO, Caracteristica.class);
        caracteristicaRepository.save(caracteristica);
        logger.info("Se cambio la Caracteristica = " + caracteristicaDTO.getId());
    }

    @Override
    public void eliminarCaracteristica(Integer id) throws ResourceNotFoundException {
        if (buscarCaracteristica(id) == null)
            throw new ResourceNotFoundException("No existe la Caracteristica con el id " + id);
        logger.info("Se elimino la Caracteristica = " + id);
        caracteristicaRepository.deleteById(id);
    }

    @Override
    public Set<CaracteristicaDTO> getTodos() {
        List<Caracteristica> caracteristicas = caracteristicaRepository.findAll();
        Set<CaracteristicaDTO> caracteristicasDTO = new HashSet<>();
        for (Caracteristica caracteristica : caracteristicas){
            caracteristicasDTO.add(mapper.convertValue(caracteristica, CaracteristicaDTO.class));
        }
        return caracteristicasDTO;
    }
}