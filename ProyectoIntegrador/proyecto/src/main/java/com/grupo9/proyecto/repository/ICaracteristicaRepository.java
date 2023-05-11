package com.grupo9.proyecto.repository;

import com.grupo9.proyecto.model.Caracteristica;
import com.grupo9.proyecto.model.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICaracteristicaRepository extends JpaRepository<Caracteristica, Integer> {
}
