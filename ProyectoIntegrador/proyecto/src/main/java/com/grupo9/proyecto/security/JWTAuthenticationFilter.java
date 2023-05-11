package com.grupo9.proyecto.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo9.proyecto.model.Rol;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.boot.context.properties.bind.Bindable.mapOf;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {


        AuthCredentials authCredentials = new AuthCredentials();

        try {
            authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
        } catch (IOException e){
        }

        UsernamePasswordAuthenticationToken usernamePat = new UsernamePasswordAuthenticationToken(
                authCredentials.getCorreo(),
                authCredentials.getPassword(),
                Collections.emptyList()

        );

        return getAuthenticationManager().authenticate(usernamePat);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();
        String token = TokenUtils.createToken(userDetails.getNombre(), userDetails.getUsername(), userDetails.getRol());

        response.addHeader("Authorization", "Bearer " + token);
        response.addHeader("Name_LastName", userDetails.getNombre() + " " + userDetails.getApellido());
        response.addHeader("Ciudad", userDetails.getCiudad().getNombre());
        response.addIntHeader("Id", userDetails.getid());
        response.addHeader("Rol", userDetails.getRol());
        response.addHeader("Access-Control-Expose-Headers", "Authorization, Name_LastName, Ciudad, Id, Rol");

        response.getWriter().flush();
        super.successfulAuthentication(request, response, chain, authResult);
    }
}
