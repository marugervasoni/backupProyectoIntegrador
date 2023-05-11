package com.grupo9.proyecto.repository;

import com.grupo9.proyecto.model.Caracteristica;
import com.grupo9.proyecto.model.Producto;
import com.grupo9.proyecto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findOneByCorreo(String correo);
}
