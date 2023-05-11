package com.grupo9.proyecto.controller;

import com.grupo9.proyecto.exceptions.ResourceNotFoundException;
import com.grupo9.proyecto.model.Usuario;
import com.grupo9.proyecto.model.UsuarioDTO;
import com.grupo9.proyecto.service.IUsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    IUsuarioService usuarioService;


    @Operation(summary = "Crea un Usuario")
    @PermitAll
    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) throws Exception {
        try {
            Usuario usuarioCreado = usuarioService.crearUsuario(usuarioDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCreado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear usuario: " + e.getMessage());
        }
    }


    @Operation(summary = "Actualiza un Usuario")
    @PutMapping
    public ResponseEntity<?> actualizarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        usuarioService.actualizarUsuario(usuarioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Trae un usuario")
    @GetMapping("/{id}")
    public UsuarioDTO getUsuario(@PathVariable Integer id) throws ResourceNotFoundException {
        return  usuarioService.buscarUsuario(id);
    }

    @Operation(summary = "Trae todos los usuarios")
    @GetMapping
    public ResponseEntity<Set<UsuarioDTO>> listar() {
        return ResponseEntity.ok(usuarioService.getTodos());
    }

    @Operation(summary = "Elimina un usuario")
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarUsuario(@PathVariable Integer id) throws ResourceNotFoundException {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.ok("Eliminado");
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> procesarErrorNotFound(ResourceNotFoundException exception){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

}

