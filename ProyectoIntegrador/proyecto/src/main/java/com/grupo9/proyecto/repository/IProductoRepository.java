package com.grupo9.proyecto.repository;

import com.grupo9.proyecto.model.Ciudad;
import com.grupo9.proyecto.model.Producto;
import com.grupo9.proyecto.model.ProductoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByCiudadNombre(String nombreCiudad);
    List<Producto> findByCategoriaTitulo(String tituloCategoria);
    Producto findByNombre(String nombre);
}
