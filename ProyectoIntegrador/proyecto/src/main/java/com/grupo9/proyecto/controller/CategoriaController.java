package com.grupo9.proyecto.controller;

import com.grupo9.proyecto.exceptions.ResourceNotFoundException;
import com.grupo9.proyecto.model.CategoriaDTO;
import com.grupo9.proyecto.service.ICategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    ICategoriaService categoriaService;


    @Operation(summary = "Crea una Categoria")
    @PostMapping
    public ResponseEntity<?> crearCategoria(@RequestBody CategoriaDTO categoriaDTO){
        categoriaService.crearCategoria(categoriaDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Actualiza una Categoria")
    @PutMapping
    public ResponseEntity<?> actualizarCategoria(@RequestBody CategoriaDTO categoriaDTO){
        categoriaService.actualizarCategoria(categoriaDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Trae una Categoria")
    @GetMapping("/{id}")
    public CategoriaDTO getCategoria(@PathVariable Integer id) throws ResourceNotFoundException {
        return  categoriaService.buscarCategoria(id);
    }

    @Operation(summary = "Trae todas las Categorias")
    @GetMapping
    public ResponseEntity<Set<CategoriaDTO>> listar() {
        return ResponseEntity.ok(categoriaService.getTodos());
    }

    @Operation(summary = "Elimina una Categoria")
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarCategoria(@PathVariable Integer id) throws ResourceNotFoundException {
        categoriaService.eliminarCategoria(id);
        return ResponseEntity.ok("Eliminado");
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> procesarErrorNotFound(ResourceNotFoundException exception){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

}