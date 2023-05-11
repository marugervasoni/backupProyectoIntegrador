package com.pi.dh.booking.service.implementations;

import com.pi.dh.booking.dto.*;
import com.pi.dh.booking.exceptions.ProductNotFoundException;
import com.pi.dh.booking.model.*;
import com.pi.dh.booking.repository.ICityRepository;
import com.pi.dh.booking.repository.ICountryRepository;
import com.pi.dh.booking.repository.IProductsRepository;
import com.pi.dh.booking.service.components.ComponentProduct;
import com.pi.dh.booking.service.interfaces.IProductService;
import com.pi.dh.booking.util.Constant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.*;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    private ComponentProduct componentProduct;
    private IProductsRepository productsRepository;
    private ICityRepository cityRepository;

    private ICountryRepository countryRepository;

    public ProductServiceImpl(ComponentProduct componentProduct, IProductsRepository productsRepository,
           ICityRepository cityRepository, ICountryRepository countryRepository){
        this.componentProduct = componentProduct;
        this.productsRepository = productsRepository;
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public ProductDTO findProductById(int id){

        ProductsEntity productEntity= productsRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException(Constant.ErrorResponse.PRODUCT_NOT_FOUND));

        return componentProduct.mapProductResponse(productEntity);
    }

    @Override
    public List<ProductDTO> findProductByCityId(int id){

        List<ProductsEntity> productsEntities = productsRepository.findByCityId(id);
        if(productsEntities.isEmpty()){
            throw new ProductNotFoundException(Constant.ErrorResponse.PRODUCT_NOT_FOUND_BY_CITY);
        }

        return componentProduct.setProductDtoResponse(productsEntities);
    }

    @Override
    public List<ProductDTO> findAllProducts(){

        List<ProductsEntity> productsEntities = productsRepository.findAll();
        if(productsEntities.isEmpty()){
            throw new ProductNotFoundException(Constant.ErrorResponse.PRODUCT_NOT_FOUND);
        }

        return componentProduct.setProductDtoResponse(productsEntities);
    }

    @Override
    public List<ProductDTO> findProductByCategory(int id){
        List<ProductsEntity> productsEntities = productsRepository.findByCategoryId(id);
        if(productsEntities.isEmpty()){
            throw new ProductNotFoundException(Constant.ErrorResponse.PRODUCT_NOT_FOUND);
        }

        return componentProduct.setProductDtoResponse(productsEntities);
    }

    @Override
    public List<ProductDTO> findRandomProducts(){

        List<ProductsEntity> productsEntities = productsRepository.findRandomProducts();
        if(productsEntities.isEmpty()){
            throw new ProductNotFoundException(Constant.ErrorResponse.PRODUCT_NOT_FOUND);
        }

        return componentProduct.setProductDtoResponse(productsEntities);
    }

    @Override
    public String createProduct(ProductDTO productDto) {

        ProductsEntity productEntity = mapProductEntityRequest(productDto, componentProduct);

        productsRepository.save(productEntity);

        return Constant.SuccessResponse.PRODUCT_CREATED;
    }

    @Override
    public List<ProductDTO> findProductByDatesAndCity(RequestDateAndCityDTO requestDateAndCityDTO) {

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        List<ProductsEntity> listEntity = productsRepository.findProductsByDatesAndCity(requestDateAndCityDTO.getCityId(), simpleDateFormat.format(requestDateAndCityDTO.getStartDate()), simpleDateFormat.format(requestDateAndCityDTO.getEndDate()));

        if(listEntity.isEmpty()){
            throw new ProductNotFoundException(Constant.ErrorResponse.PRODUCT_NOT_FOUND);
        }

        return componentProduct.setProductDtoResponse(listEntity);
    }
    PoliticEntity mapPoliticEntityRequest(ProductDTO productDto, ComponentProduct componentProduct){

        componentProduct.validatePoliticsFields(productDto);

        RulesEntity rule = new RulesEntity();
        if(productDto.getPolitic().getRule().getTitle().isBlank()){
            rule.setTitle(productDto.getPolitic().getRule().getTitle());
        }

        rule.setDescription(productDto.getPolitic().getRule().getDescription());

        SecurityEntity security = new SecurityEntity();
        security.setTitle(productDto.getPolitic().getSecurity().getTitle());
        security.setDescription(productDto.getPolitic().getSecurity().getDescription());

        CancellationEntity cancellation = new CancellationEntity();
        cancellation.setTitle(productDto.getPolitic().getCancellation().getTitle());
        cancellation.setDescription(productDto.getPolitic().getCancellation().getDescription());

        PoliticEntity politic = new PoliticEntity();
        politic.setCancellation(cancellation);
        politic.setRule(rule);
        politic.setSecurity(security);

        return politic;
    }

    ProductsEntity mapProductEntityRequest(ProductDTO productDto, ComponentProduct componentProduct){

        componentProduct.validateProductsFields(productDto);

        ProductsEntity productEntity = new ProductsEntity();

        productEntity.setTitle(productDto.getTitle());
        productEntity.setAvailability(productDto.getAvailability());
        productEntity.setDescription(productDto.getDescription());

        Integer cityId = cityRepository.findByName(productDto.getCity().getName());

        CityEntity city = new CityEntity();
        CountryEntity country= new CountryEntity();
        if(Objects.isNull(cityId)){
            System.out.println("City id Null");
            city.setName(productDto.getCity().getName());
            Integer countryId = countryRepository.findByName(productDto.getCity().getCountry().getName());
            System.out.println("country id " + countryId);
            CountryEntity countryvalue = new CountryEntity();
            if(Objects.isNull(countryId)){
                country.setName(productDto.getCity().getCountry().getName());
                countryvalue = countryRepository.save(country);
                country.setId(countryvalue.getId());
            }else{
                country.setId(countryId);
            }

            //country.setName(productDto.getCity().getCountry().getName());
            city.setCountry(country);

            System.out.println("City1:" + city.getName() + city.getCountry());
            System.out.println("Country1:" + country.getName() + country.getId());
            cityRepository.save(city);
        }else{
            Integer countryId = countryRepository.findByName(productDto.getCity().getCountry().getName());
            country.setId(countryId);


            city.setId(cityId);
            city.setCountry(country);

            System.out.println("City2:" + city.getName());
            System.out.println("City2:" + city.getId());
            System.out.println("City2:" + city.getCountry().getName());
            System.out.println("City2:" + city.getCountry().getId());

        }

        productEntity.setCity(city);

        CategoryEntity category = new CategoryEntity();
        category.setId(productDto.getCategory().getId());
        productEntity.setCategory(category);

        CharacteristicEntity characteristic = new CharacteristicEntity();
        characteristic.setTv(productDto.getCharacteristic().getTv());
        characteristic.setKitchen(productDto.getCharacteristic().getKitchen());
        characteristic.setPool(productDto.getCharacteristic().getPool());
        characteristic.setWifi(productDto.getCharacteristic().getWifi());
        characteristic.setFreeParking(productDto.getCharacteristic().getFreeParking());
        characteristic.setConditionAir(productDto.getCharacteristic().getConditionAir());
        characteristic.setPetsAllowed(productDto.getCharacteristic().getPetsAllowed());
        productEntity.setCharacteristic(characteristic);

        List<ImageEntity> images = new ArrayList<>();

        for(ImageDTO image: productDto.getImages()){
            ImageEntity imageEntity = new ImageEntity();
            imageEntity.setUrl(image.getUrl());
            imageEntity.setTitle(image.getTitle());
            images.add(imageEntity);
        }
        productEntity.setImages(images);

        productEntity.setPolitic(mapPoliticEntityRequest(productDto, componentProduct));

        return productEntity;
    }
}
