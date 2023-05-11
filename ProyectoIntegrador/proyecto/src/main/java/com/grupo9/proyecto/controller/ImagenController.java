package com.grupo9.proyecto.controller;

import com.grupo9.proyecto.exceptions.ResourceNotFoundException;
import com.grupo9.proyecto.model.ImagenDTO;
import com.grupo9.proyecto.model.ProductoDTO;
import com.grupo9.proyecto.service.IImagenService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/imagen")
public class ImagenController {

    @Autowired
    IImagenService imagenService;


    @Operation(summary = "Crea una Imagen")
    @PostMapping
    public ResponseEntity<?> crearImagen(@RequestBody ImagenDTO imagenDTO) throws ResourceNotFoundException {
        imagenService.crearImagen(imagenDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Actualiza una Imagen")
    @PutMapping
    public ResponseEntity<?> actualizarImagen(@RequestBody ImagenDTO imagenDTO){
        imagenService.actualizarImagen(imagenDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Trae una imagen")
    @GetMapping("/{id}")
    public ImagenDTO getImagen(@PathVariable Integer id) throws ResourceNotFoundException {
        return  imagenService.buscarImagen(id);
    }

    @Operation(summary = "Trae todas las imagenes")
    @GetMapping
    public ResponseEntity<Set<ImagenDTO>> listar() {
        return ResponseEntity.ok(imagenService.getTodos());
    }

    @Operation(summary = "Elimina una Imagen")
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarImagen(@PathVariable Integer id) throws ResourceNotFoundException {
        imagenService.eliminarImagen(id);
        return ResponseEntity.ok("Eliminado");
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity uploadFile(@RequestParam MultipartFile[] files){
        System.out.println(files);
        for (int i = 0 ; i < files.length; i++){
            System.out.println(String.format("File name '%s' uploaded successfully.", files[i].getOriginalFilename()));

        }
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> procesarErrorNotFound(ResourceNotFoundException exception){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

}

