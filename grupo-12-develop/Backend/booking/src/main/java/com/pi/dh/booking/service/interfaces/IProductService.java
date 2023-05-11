package com.pi.dh.booking.service.interfaces;

import com.pi.dh.booking.dto.ProductDTO;
import com.pi.dh.booking.dto.RequestDateAndCityDTO;
import com.pi.dh.booking.model.ProductsEntity;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

public interface IProductService {

    ProductDTO findProductById(int id);

    List<ProductDTO> findProductByCityId(int id);

    List<ProductDTO> findAllProducts();

    List<ProductDTO> findRandomProducts();

    String createProduct(ProductDTO productDTO);

    List<ProductDTO> findProductByCategory(int id);

    List<ProductDTO> findProductByDatesAndCity(RequestDateAndCityDTO requestDateAndCityDTO);
}
