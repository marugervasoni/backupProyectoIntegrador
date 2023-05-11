package com.grupo9.proyecto.controller;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo9.proyecto.exceptions.ResourceNotFoundException;
import com.grupo9.proyecto.model.*;
import com.grupo9.proyecto.repository.ICaracteristicaRepository;
import com.grupo9.proyecto.repository.IProductoRepository;
import com.grupo9.proyecto.service.IProductoService;
import com.grupo9.proyecto.service.S3BucketStorageService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.webjars.NotFoundException;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    IProductoService productoService;

    @Autowired
    IProductoRepository productoRepository;

    @Autowired
    ICaracteristicaRepository caracteristicaRepository;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    S3BucketStorageService service;


    @Operation(summary = "Crea un producto")
    @PostMapping
    public ResponseEntity<Integer> crearProducto(@RequestParam("producto") String productoString,
                                                 @RequestParam("files") MultipartFile[] files) throws Exception {
        ProductoDTO productoDTO = mapper.readValue(productoString, ProductoDTO.class);
        productoService.crearProducto(productoDTO, files);
        Integer productoId = productoDTO.getId();
        return ResponseEntity.ok(productoId);
    }

    @Operation(summary = "Actualiza un producto")
    @PutMapping
    public ResponseEntity<?> actualizarProducto(@RequestBody ProductoDTO productoDTO){
        productoService.actualizarProducto(productoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Trae un producto")
    @GetMapping("/{id}")
    public Producto getProducto(@PathVariable Integer id) throws ResourceNotFoundException {
        return  productoService.buscarProducto(id);
    }

    @Operation(summary = "Trae un producto a traves del Nombre")
    @GetMapping("find/{nombre}")
    public ProductoDTO getProductoByNombre(@PathVariable String nombre){
        return productoService.filtrarProductosPorNombre(nombre);
    }


    @Operation(summary = "Trae todos los productos")
    @GetMapping("/all")
    public ResponseEntity<Set<ProductoDTO>> listar() {
        return ResponseEntity.ok(productoService.getTodos());
    }

    @Operation(summary = "Elimina un producto")
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarProducto(@PathVariable Integer id) throws ResourceNotFoundException {
        productoService.eliminarProducto(id);
        return ResponseEntity.ok("Eliminado");
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> procesarErrorNotFound(ResourceNotFoundException exception){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @Operation(summary = "Busca productos por ciudad")
    @GetMapping("ciudad/{nombreCiudad}")
    public List<ProductoDTO> listarProductosPorCiudad(@PathVariable String nombreCiudad) {
        List<Producto> productos = productoRepository.findByCiudadNombre(nombreCiudad);
        List<ProductoDTO> productosDTO = productos.stream()
                .map(producto -> mapper.convertValue(producto, ProductoDTO.class))
                .collect(Collectors.toList());
        return productosDTO;
    }

    @Operation(summary = "Busca productos por categoria")
    @GetMapping("categoria/{tituloCategoria}")
    public List<ProductoDTO> listarProductosPorCategoria(@PathVariable String tituloCategoria) {
        List<Producto> productos = productoRepository.findByCategoriaTitulo(tituloCategoria);
        List<ProductoDTO> productosDTO = productos.stream()
                .map(producto -> mapper.convertValue(producto, ProductoDTO.class))
                .collect(Collectors.toList());
        return productosDTO;
    }

    @Operation(summary = "Busca Productos Por Ciudad y Fechas Disponibles")
    @GetMapping("/buscarPorCiudadYFechas")
    public ResponseEntity<?> buscarPorCiudadYFechas(@RequestParam String ciudad,
                                                    @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
                                                    @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) {
        try {
            List<Producto> productos = productoService.buscarProductosPorCiudadYFechas(ciudad, fechaInicio, fechaFin);
            return ResponseEntity.ok(productos);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
