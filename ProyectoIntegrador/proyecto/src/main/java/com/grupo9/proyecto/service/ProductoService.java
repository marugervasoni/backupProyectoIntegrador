package com.grupo9.proyecto.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo9.proyecto.exceptions.ResourceNotFoundException;
import com.grupo9.proyecto.model.*;
import com.grupo9.proyecto.repository.ICaracteristicaRepository;
import com.grupo9.proyecto.repository.IImagenRepository;
import com.grupo9.proyecto.repository.IProductoRepository;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private CaracteristicaService caracteristicaService;

    @Autowired
    private ICaracteristicaRepository caracteristicaRepository;

    @Autowired
    private IImagenService imagenservice;

    @Autowired
    private IImagenRepository imagenRepository;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private CiudadService ciudadService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    S3BucketStorageService service;


    private static final org.apache.log4j.Logger logger = Logger.getLogger(ProductoService.class);

    @Autowired
    ObjectMapper mapper;

    @Override
    public Producto crearProducto(ProductoDTO productoDTO, MultipartFile[] files) throws Exception {
        Producto producto = mapper.convertValue(productoDTO, Producto.class);


        if (productoDTO.getCiudad() != null){
            Ciudad ciudad = mapper.convertValue(productoDTO.getCiudad(), Ciudad.class);
            producto.setCiudad(ciudad);
        }
        if (producto.getCategoria() != null){
            Categoria categoria = categoriaService.crearCategoria(productoDTO.getCategoria());
            producto.getCategoria().setId(categoria.getId());
        }

        if (productoDTO.getCaracteristica() != null) {
            Caracteristica caracteristica = mapper.convertValue(productoDTO.getCaracteristica(), Caracteristica.class);
            producto.setCaracteristica(caracteristica);
        }

        if (producto.getUsuario() != null){
            Usuario usuario = usuarioService.crearUsuario(productoDTO.getUsuario());
            producto.getUsuario().setId(usuario.getId());
        }

        List<Imagen> imagenes = new ArrayList<>();

        Integer counter = 0;
        for (MultipartFile file : files) {
            counter ++;
            String nombreArchivo = "lodging_images/"+ productoDTO.getNombre().replace(" ", "-")+"/" + counter.toString();
            service.uploadFile(nombreArchivo, file);
            String extension = FilenameUtils.getExtension(file.getOriginalFilename());
            String urlImagen = "/" + productoDTO.getNombre().replace(" ", "-")+"/" + counter.toString() + "."+ extension;
            
            Imagen imagen = new Imagen();
            imagen.setTitulo(productoDTO.getNombre().replace(" ", "-"));
            imagen.setUrl(urlImagen);
            imagenes.add(imagen);
            imagenRepository.save(imagen);
        }
        producto.setImagenes(imagenes);


        logger.info("Se creo el producto = " + productoDTO.getTitulo() + "-" + productoDTO.getTipo());
        return productoRepository.save(producto);
    }

    @Override
    public Producto buscarProducto(Integer id) {
        Optional<Producto> producto = productoRepository.findById(id);
        Producto productoEncontrado = null;
        if (producto.isPresent()) {
            productoEncontrado = producto.get();
            logger.info("Se encontro el alojamiento = " + productoEncontrado.getTitulo() + "-" + productoEncontrado.getTipo());
        }
        return productoEncontrado;
    }



    @Override
    public void actualizarProducto(ProductoDTO productoDTO) {
        Producto producto = mapper.convertValue(productoDTO, Producto.class);
        productoRepository.save(producto);
        logger.info("Se cambio el Producto = " + productoDTO.getId());
    }

    @Override
    public ProductoDTO filtrarProductosPorNombre(String nombre) {
        Producto producto = productoRepository.findByNombre(nombre);
        if (producto != null) {
            ProductoDTO productoDTO = mapper.convertValue(producto, ProductoDTO.class);
            List<ReservaDTO> reservasDTO = new ArrayList<>();
            for (Reserva reserva : producto.getReservas()) {
                reservasDTO.add(mapper.convertValue(reserva, ReservaDTO.class));
            }
            productoDTO.setReservas(reservasDTO);
            return productoDTO;
        }
        return null;
    }

    @Override
    public void eliminarProducto(Integer id) throws ResourceNotFoundException {
        if (buscarProducto(id) == null)
            throw new ResourceNotFoundException("No existe el Producto con el id " + id);
        logger.info("Se elimino el Producto = " + id);
        productoRepository.deleteById(id);
    }

    @Override
    public Set<ProductoDTO> getTodos() {
        List<Producto> productos = productoRepository.findAll();
        Set<ProductoDTO> productosDTO = new HashSet<>();
        for (Producto producto : productos){
            productosDTO.add(mapper.convertValue(producto, ProductoDTO.class));
        }
        return productosDTO;
    }

    @Override
    public List<ProductoDTO> filtrarProductosPorCiudad(String nombreCiudad) {
        List<Producto> productos = productoRepository.findByCiudadNombre(nombreCiudad);
        List<ProductoDTO> productosDTO = new ArrayList<>();

        for (Producto producto : productos) {
            productosDTO.add(mapper.convertValue(producto, ProductoDTO.class));
        }

        logger.info("Se encontraron " + productosDTO.size() + " productos en la ciudad de " + nombreCiudad);
        return productosDTO;
    }
    @Override
    public List<ProductoDTO> filtrarProductosPorCategoria(String tituloCategoria) {
        List<Producto> productos = productoRepository.findByCategoriaTitulo(tituloCategoria);
        List<ProductoDTO> productosDTO = new ArrayList<>();

        for (Producto producto : productos) {
            productosDTO.add(mapper.convertValue(producto, ProductoDTO.class));
        }

        return productosDTO;
    }

    @Override
    public List<Producto> buscarProductosPorCiudadYFechas(String ciudad, Date fechaInicio, Date fechaFin) {
        List<Producto> productos = productoRepository.findByCiudadNombre(ciudad);
        List<Producto> productosFiltrados = new ArrayList<>();
        for (Producto producto : productos) {
            List<Reserva> reservas = producto.getReservas();
            boolean disponible = true;
            for (Reserva reserva : reservas) {
                Date inicioReserva = reserva.getFechaInicial();
                Date finReserva = reserva.getFechaFinal();
                if (inicioReserva.before(fechaFin) && finReserva.after(fechaInicio) ||
                        inicioReserva.equals(fechaFin) || finReserva.equals(fechaFin))  {

                    disponible = false;
                    break;
                }
            }
            if (disponible) {
                productosFiltrados.add(producto);
            }
        }
        return productosFiltrados;
    }

}
