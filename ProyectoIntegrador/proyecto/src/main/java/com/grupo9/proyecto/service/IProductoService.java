package com.grupo9.proyecto.service;

import com.grupo9.proyecto.exceptions.ResourceNotFoundException;
import com.grupo9.proyecto.model.Ciudad;
import com.grupo9.proyecto.model.Producto;
import com.grupo9.proyecto.model.ProductoDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface IProductoService {
    Producto crearProducto(ProductoDTO productoDTO, MultipartFile[] files) throws Exception;
    Producto buscarProducto (Integer id) throws ResourceNotFoundException;
    void actualizarProducto (ProductoDTO productoDTO);
    ProductoDTO filtrarProductosPorNombre(String nombre);
    void eliminarProducto (Integer id) throws ResourceNotFoundException;
    Set<ProductoDTO> getTodos();
    List<ProductoDTO> filtrarProductosPorCiudad(String  ciudad);
    List<ProductoDTO> filtrarProductosPorCategoria(String  categoria);
    List<Producto> buscarProductosPorCiudadYFechas(String ciudad, Date fechaInicio, Date fechaFin) throws ResourceNotFoundException;
}
