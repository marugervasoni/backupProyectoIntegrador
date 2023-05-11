package com.grupo9.proyecto.repository;

import com.grupo9.proyecto.model.Imagen;
import com.grupo9.proyecto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IImagenRepository extends JpaRepository<Imagen, Integer> {
}
