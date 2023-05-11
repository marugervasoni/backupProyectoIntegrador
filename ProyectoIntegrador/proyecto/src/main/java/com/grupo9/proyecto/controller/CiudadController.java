package com.grupo9.proyecto.controller;

import com.grupo9.proyecto.exceptions.ResourceNotFoundException;
import com.grupo9.proyecto.model.CiudadDTO;
import com.grupo9.proyecto.service.ICiudadService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/ciudad")
public class CiudadController {

    @Autowired
    ICiudadService ciudadService;


    @Operation(summary = "Crea una Ciudad")
    @PostMapping
    public ResponseEntity<?> crearCiudad(@RequestBody CiudadDTO ciudadDTO){
        ciudadService.crearCiudad(ciudadDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Actualiza una Ciudad")
    @PutMapping
    public ResponseEntity<?> actualizarCiudad(@RequestBody CiudadDTO ciudadDTO){
        ciudadService.actualizarCiudad(ciudadDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Trae una Ciudad")
    @GetMapping("/{id}")
    public CiudadDTO getCiudad(@PathVariable Integer id) throws ResourceNotFoundException {
        return  ciudadService.buscarCiudad(id);
    }

    @Operation(summary = "Trae todas las Ciudades")
    @GetMapping
    public ResponseEntity<Set<CiudadDTO>> listar() {
        return ResponseEntity.ok(ciudadService.getTodos());
    }

    @Operation(summary = "Elimina una Ciudad")
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarCiudad(@PathVariable Integer id) throws ResourceNotFoundException {
        ciudadService.eliminarCiudad(id);
        return ResponseEntity.ok("Eliminado");
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> procesarErrorNotFound(ResourceNotFoundException exception){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

}
