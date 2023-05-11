package com.grupo9.proyecto.controller;

import com.grupo9.proyecto.exceptions.ResourceNotFoundException;
import com.grupo9.proyecto.model.Caracteristica;
import com.grupo9.proyecto.model.CaracteristicaDTO;
import com.grupo9.proyecto.model.CategoriaDTO;
import com.grupo9.proyecto.service.ICaracteristicaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/caracteristica")
public class CaracteristicaController {

    @Autowired
    ICaracteristicaService caracteristicaService;


    @Operation(summary = "Crea una Caracteristica")
    @PostMapping
    public ResponseEntity<?> crearCaracteristica(@RequestBody CaracteristicaDTO caracteristicaDTO){
        caracteristicaService.crearCaracteristica(caracteristicaDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Actualiza una Caracteristica")
    @PutMapping
    public ResponseEntity<?> actualizarCaracteristica(@RequestBody CaracteristicaDTO caracteristicaDTO){
        caracteristicaService.actualizarCaracteristica(caracteristicaDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Trae una Caracteristica")
    @GetMapping("/{id}")
    public CaracteristicaDTO getCaracteristica(@PathVariable Integer id) throws ResourceNotFoundException {
        return  caracteristicaService.buscarCaracteristica(id);
    }

    @Operation(summary = "Trae todas las Caracteristicas")
    @GetMapping
    public ResponseEntity<Set<CaracteristicaDTO>> listar() {
        return ResponseEntity.ok(caracteristicaService.getTodos());
    }

    @Operation(summary = "Elimina una Caracteristica")
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarCaracteristica(@PathVariable Integer id) throws ResourceNotFoundException {
        caracteristicaService.eliminarCaracteristica(id);
        return ResponseEntity.ok("Eliminado");
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> procesarErrorNotFound(ResourceNotFoundException exception){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

}
