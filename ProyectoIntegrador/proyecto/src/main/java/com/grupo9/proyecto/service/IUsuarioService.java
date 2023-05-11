package com.grupo9.proyecto.service;

import com.grupo9.proyecto.exceptions.ResourceNotFoundException;
import com.grupo9.proyecto.model.Imagen;
import com.grupo9.proyecto.model.ImagenDTO;
import com.grupo9.proyecto.model.Usuario;
import com.grupo9.proyecto.model.UsuarioDTO;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Set;

public interface IUsuarioService {
    Usuario crearUsuario(UsuarioDTO usuarioDTO) throws Exception;
    UsuarioDTO buscarUsuario (Integer id) throws ResourceNotFoundException;
    void actualizarUsuario (UsuarioDTO usuarioDTO);
    void eliminarUsuario (Integer id) throws ResourceNotFoundException;
    Set<UsuarioDTO> getTodos();
}

