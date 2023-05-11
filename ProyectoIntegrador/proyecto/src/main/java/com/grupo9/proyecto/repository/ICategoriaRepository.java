package com.grupo9.proyecto.repository;

import com.grupo9.proyecto.model.Categoria;
import com.grupo9.proyecto.model.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {
}
