package com.grupo9.proyecto.repository;

import com.grupo9.proyecto.model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad, Integer> {
}
