package com.grupo9.proyecto.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;


@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class TokenUtils {
    private final static String ACCESS_TOKEN_SECRET = "aRpIFkJvOY!?xo=ITue?Phr!Kk65AikxOip";
    private final static Long ACCEESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;


    public static String createToken(String nombre, String correo, String rol){
        long expirationTime = ACCEESS_TOKEN_VALIDITY_SECONDS * 1_000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);
        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre", nombre);
        extra.put("rol", rol);

        return Jwts.builder()
                .setSubject(correo)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String correo = claims.getSubject();
            String rol = (String) claims.get("rol");

            Collection<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(rol));

            return new UsernamePasswordAuthenticationToken(correo, null, authorities);
        } catch (JwtException e){
            return  null;
        }
    }
}
