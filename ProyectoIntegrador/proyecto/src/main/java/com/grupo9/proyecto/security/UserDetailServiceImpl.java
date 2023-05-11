package com.grupo9.proyecto.security;

import com.grupo9.proyecto.model.Usuario;
import com.grupo9.proyecto.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
       Usuario usuario = usuarioRepository
                .findOneByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con email " + correo  + " no existe."));

       return new UserDetailsImpl(usuario);
    }
}
