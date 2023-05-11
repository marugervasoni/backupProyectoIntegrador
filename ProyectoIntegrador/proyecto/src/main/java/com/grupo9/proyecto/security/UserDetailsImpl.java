package com.grupo9.proyecto.security;

import com.grupo9.proyecto.model.Ciudad;
import com.grupo9.proyecto.model.Rol;
import com.grupo9.proyecto.model.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserDetailsImpl  implements UserDetails {
    private final Usuario usuario;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(usuario.getRol().getDescripcion()));
    }


    @Override
    public String getPassword() {
        return usuario.getContraseña();
    }

    @Override
    public String getUsername() {
        return usuario.getCorreo();
    }

    public String getApellido(){
        return usuario.getApellido();
    }

    public Integer getid() {
        return usuario.getId();
    }

    public String getRol() {return usuario.getRol().getDescripcion();}

    public Ciudad getCiudad() {return usuario.getCiudad();}
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getNombre(){
        return usuario.getNombre();
    }
}
