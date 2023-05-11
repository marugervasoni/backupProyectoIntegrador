package com.grupo9.proyecto.controller;

import com.grupo9.proyecto.exceptions.ResourceNotFoundException;
import com.grupo9.proyecto.model.Reserva;
import com.grupo9.proyecto.service.IReservaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    IReservaService reservaService;


    @Operation(summary = "Crea una Reserva")
    @PostMapping
    public ResponseEntity<?> crearReserva(@RequestBody Reserva reserva) throws ResourceNotFoundException, ParseException {
        Reserva reserva1 = reservaService.crearReserva(reserva);
        return ResponseEntity.ok(reserva1);
    }

    @Operation(summary = "Actualiza una Reserva")
    @PutMapping
    public ResponseEntity<?> actualizarCaracteristica(@RequestBody Reserva reserva) throws ResourceNotFoundException {
        reservaService.actualizarReserva(reserva);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Trae una Reserva")
    @GetMapping("/{id}")
    public Reserva getReserva(@PathVariable Integer id) throws ResourceNotFoundException {
        return  reservaService.buscarReserva(id);
    }

    @Operation(summary = "Trae todas las Reservas")
    @GetMapping
    public ResponseEntity<Set<Reserva>> listar() {
        return ResponseEntity.ok(reservaService.getTodos());
    }

    @Operation(summary = "Elimina una Reserva")
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarReserva(@PathVariable Integer id) throws ResourceNotFoundException {
        reservaService.cancelarReserva(id);
        return ResponseEntity.ok("Eliminado");
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> procesarErrorNotFound(ResourceNotFoundException exception){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

}


