package com.pi.dh.booking.controller;

import com.pi.dh.booking.dto.ProductDTO;
import com.pi.dh.booking.dto.RequestDateAndCityDTO;
import com.pi.dh.booking.dto.ResponseDTO;
import com.pi.dh.booking.model.ProductsEntity;
import com.pi.dh.booking.service.interfaces.IProductService;
import com.pi.dh.booking.util.Constant;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constant.Endpoints.PRODUCTS)
public class ProductController {

    private IProductService productService;

    public ProductController(IProductService productService){
        this.productService = productService;
    }

    @GetMapping(produces = "application/json")
    public ResponseDTO<List<ProductDTO>> findAllProducts(){

        List<ProductDTO> response = productService.findAllProducts();

        return new ResponseDTO<>(HttpStatus.OK.value(),
                Constant.SuccessResponse.GET_ALL_PRODUCTS, response);
    }

    @GetMapping(value=Constant.Endpoints.GET_PRODUCT_BY_ID, produces="application/json")
    public ResponseDTO<ProductDTO> findById(@PathVariable("id") int id){

        ProductDTO response = productService.findProductById(id);

        return new ResponseDTO<>(HttpStatus.OK.value(),
                Constant.SuccessResponse.FIND_PRODUCT_BY_ID, response);
    }

    @GetMapping(value=Constant.Endpoints.GET_PRODUCTS_BY_CITY, produces="application/json")
    public ResponseDTO<List<ProductDTO>> findByCity(@PathVariable("id") int id){

        List<ProductDTO> response = productService.findProductByCityId(id);

        return new ResponseDTO<>(HttpStatus.OK.value(),
                Constant.SuccessResponse.GET_PRODUCTS_BY_CITY , response);
    }

    @GetMapping(value = Constant.Endpoints.GET_PRODUCTS_RANDOMLY, produces = "application/json")
    public ResponseDTO<List<ProductDTO>> findRandomProducts(){

        List<ProductDTO> response = productService.findRandomProducts();

        return new ResponseDTO<>(HttpStatus.OK.value(),
                Constant.SuccessResponse.GET_RANDOM_PRODUCTS,response);
    }

    @GetMapping(value=Constant.Endpoints.GET_PRODUCTS_BY_CATEGORY, produces = "application/json")
    public ResponseDTO<List<ProductDTO>> findProductsByCategory(@PathVariable("id") int id){
        List<ProductDTO> response = productService.findProductByCategory(id);

        return new ResponseDTO<>(HttpStatus.OK.value(), Constant.SuccessResponse.GET_PRODUCTS_BY_CATEGORY, response);
    }

    @PostMapping(value=Constant.Endpoints.CREATE_PRODUCT, produces="application/json")
    public ResponseDTO<String> createProducts(@RequestBody ProductDTO productDTO){

        String message = productService.createProduct(productDTO);

        return new ResponseDTO<>(HttpStatus.OK.value(), message);
    }

    @GetMapping(value=Constant.Endpoints.GET_PRODUCTS_BY_CITY_DATE, produces = "application/json")
    public ResponseDTO<List<ProductDTO>> findProductsByDatesAndCity(@RequestBody RequestDateAndCityDTO requestDateAndCityDTO){

        List<ProductDTO> response = productService.findProductByDatesAndCity(requestDateAndCityDTO);

        return new ResponseDTO<>(HttpStatus.OK.value(), Constant.SuccessResponse.GET_PRODUCTS_BY_CITY_AND_DATES, response);
    }
}
