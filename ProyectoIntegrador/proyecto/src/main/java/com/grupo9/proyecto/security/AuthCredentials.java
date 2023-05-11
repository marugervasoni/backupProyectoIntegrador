package com.grupo9.proyecto.security;

import com.grupo9.proyecto.model.Rol;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.List;

@Data
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class AuthCredentials {
    private String correo;
    private String password;
}
