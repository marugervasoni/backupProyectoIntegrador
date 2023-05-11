package com.grupo9.proyecto.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo9.proyecto.exceptions.ResourceNotFoundException;
import com.grupo9.proyecto.model.*;
import com.grupo9.proyecto.repository.ICiudadRepository;
import com.grupo9.proyecto.repository.IRolRepository;
import com.grupo9.proyecto.repository.IUsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.transaction.Transactional;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UsuarioService implements IUsuarioService {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private ICiudadRepository ciudadrRepository;

    private static final org.apache.log4j.Logger logger = Logger.getLogger(UsuarioService.class);

    @Autowired
    ObjectMapper mapper;

    @Autowired
    PasswordEncoder passwordEncoder;


    public boolean existeUsuarioPorCorreo(String correo) {
        Optional<Usuario> usuario = usuarioRepository.findOneByCorreo(correo);
        return usuario.isPresent();
    }

    @Override
    public Usuario crearUsuario(UsuarioDTO usuarioDTO) throws Exception {
        Usuario usuario = null;

        if (usuarioDTO.getId() != null) {
            usuario = usuarioRepository.findById(usuarioDTO.getId()).orElse(null);
        }

        if (existeUsuarioPorCorreo(usuarioDTO.getCorreo())) {
            throw new Exception("Ya existe un usuario con el correo electrónico proporcionado");
        }

        if (usuario == null) {
            usuario = mapper.convertValue(usuarioDTO, Usuario.class);
            String encodedPassword = passwordEncoder.encode(usuarioDTO.getContraseña());
            usuario.setContraseña(encodedPassword);
            logger.info("Se creo el Usuario = " + usuarioDTO.getNombre() + "-" + usuarioDTO.getApellido());
        }

        if (usuarioDTO.getCiudad() != null) {
            Ciudad ciudad = ciudadrRepository.findById(usuarioDTO.getCiudad().getId()).orElse(null);
            usuario.setCiudad(ciudad);
        }

        usuario = usuarioRepository.save(usuario);

        return usuario;
    }



    @Override
    public UsuarioDTO buscarUsuario(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        UsuarioDTO usuarioDTO = null;
        if (usuario.isPresent())
            usuarioDTO = mapper.convertValue(usuario, UsuarioDTO.class);
        logger.info("Se encontro el Usuario = " + usuarioDTO.getNombre() + "-" + usuarioDTO.getApellido());
        return usuarioDTO;
    }

    @Override
    public void actualizarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = mapper.convertValue(usuarioDTO, Usuario.class);
        usuarioRepository.save(usuario);
        logger.info("Se cambio el usuario = " + usuarioDTO.getId());
    }

    @Override
    public void eliminarUsuario(Integer id) throws ResourceNotFoundException {
        if (buscarUsuario(id) == null)
            throw new ResourceNotFoundException("No existe el usuario con el id " + id);
        logger.info("Se elimino el usuario = " + id);
        usuarioRepository.deleteById(id);
    }

    @Override
    public Set<UsuarioDTO> getTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        Set<UsuarioDTO> usuariosDTO = new HashSet<>();
        for (Usuario usuario : usuarios){
            usuariosDTO.add(mapper.convertValue(usuario, UsuarioDTO.class));
        }
        return usuariosDTO;
    }
}
