package com.pi.dh.booking.service.components;

import com.pi.dh.booking.dto.*;
import com.pi.dh.booking.exceptions.*;
import com.pi.dh.booking.model.ImageEntity;
import com.pi.dh.booking.model.ProductsEntity;
import com.pi.dh.booking.util.Constant;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ComponentProduct {

    public List<ProductDTO> setProductDtoResponse(List<ProductsEntity> productEn){

        List<ProductDTO> productsDto = new ArrayList<>();
        for(ProductsEntity product: productEn) {
            ProductDTO productDTO = new ProductDTO();
            productDTO = mapProductResponse(product);
            productsDto.add(productDTO);
        }
        return productsDto;
    }

    public ProductDTO mapProductResponse(ProductsEntity productEntity){
        ProductDTO productDto = new ProductDTO();
        productDto.setId(productEntity.getId());
        productDto.setTitle(productEntity.getTitle());
        productDto.setDescription(productEntity.getDescription());
        productDto.setAvailability(productEntity.getAvailability());

        CityDTO cityDto = new CityDTO();
        cityDto.setId(productEntity.getCity().getId());
        cityDto.setName(productEntity.getCity().getName());

        CountryDTO country = new CountryDTO();
        country.setId(productEntity.getCity().getCountry().getId());
        country.setName(productEntity.getCity().getCountry().getName());

        cityDto.setCountry(country);

        productDto.setCity(cityDto);

        List<ImageDTO> imagesDto = new ArrayList<>();
        for(ImageEntity image: productEntity.getImages()){
            ImageDTO imageDto = new ImageDTO();
            imageDto.setId(image.getId());
            imageDto.setTitle(image.getTitle());
            imageDto.setUrl(image.getUrl());

            imagesDto.add(imageDto);
        }

        productDto.setImages(imagesDto);

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(productEntity.getCategory().getId());
        categoryDTO.setTitle(productEntity.getCategory().getTitle());
        categoryDTO.setDescription(productEntity.getCategory().getDescription());
        categoryDTO.setImageUrl(productEntity.getCategory().getImageUrl());
        productDto.setCategory(categoryDTO);

        CharacteristicDTO characteristicDTO = new CharacteristicDTO();
        characteristicDTO.setId(productEntity.getCharacteristic().getId());
        characteristicDTO.setKitchen(productEntity.getCharacteristic().getKitchen());
        characteristicDTO.setTv(productEntity.getCharacteristic().getTv());
        characteristicDTO.setPool(productEntity.getCharacteristic().getPool());
        characteristicDTO.setWifi(productEntity.getCharacteristic().getWifi());
        characteristicDTO.setFreeParking(productEntity.getCharacteristic().getFreeParking());
        characteristicDTO.setPetsAllowed(productEntity.getCharacteristic().getPetsAllowed());
        characteristicDTO.setConditionAir(productEntity.getCharacteristic().getConditionAir());
        productDto.setCharacteristic(characteristicDTO);

        PoliticDTO politicDTO = mapPoliticDtoResponse(productEntity);

        productDto.setPolitic(politicDTO);

        return productDto;
    }

    public PoliticDTO mapPoliticDtoResponse(ProductsEntity productEntity){

        RulesDTO ruleDto = new RulesDTO();
        ruleDto.setId(productEntity.getPolitic().getRule().getId());
        ruleDto.setTitle(productEntity.getPolitic().getRule().getTitle());
        ruleDto.setDescription(productEntity.getPolitic().getRule().getDescription());

        SecurityDTO securityDto = new SecurityDTO();
        securityDto.setId(productEntity.getPolitic().getSecurity().getId());
        securityDto.setTitle(productEntity.getPolitic().getSecurity().getTitle());
        securityDto.setDescription(productEntity.getPolitic().getSecurity().getDescription());

        CancellationDTO cancellationDTO = new CancellationDTO();
        cancellationDTO.setId(productEntity.getPolitic().getCancellation().getId());
        cancellationDTO.setTitle(productEntity.getPolitic().getCancellation().getTitle());
        cancellationDTO.setDescription(productEntity.getPolitic().getCancellation().getDescription());

        PoliticDTO politicDTO = new PoliticDTO();
        politicDTO.setId(productEntity.getPolitic().getId());
        politicDTO.setRule(ruleDto);
        politicDTO.setSecurity(securityDto);
        politicDTO.setCancellation(cancellationDTO);

        return politicDTO;
    }

    public void validatePoliticsFields(ProductDTO productDto){
        if(productDto.getPolitic().getRule().getTitle().isBlank()){
            throw new GeneralProductFieldNullException(Constant.
                    ErrorResponse.RULE_TITLE_FIELD_NULL);
        }
        if(productDto.getPolitic().getRule().getDescription().isBlank()){
            throw new GeneralProductFieldNullException(Constant.
                    ErrorResponse.RULE_DESCRIPTION_FIELD_NULL);
        }
        if(productDto.getPolitic().getSecurity().getTitle().isBlank()){
            throw new GeneralProductFieldNullException(Constant.
                    ErrorResponse.SECURITY_TITLE_FIELD_NULL);
        }
        if(productDto.getPolitic().getSecurity().getDescription().isBlank()){
            throw new GeneralProductFieldNullException(Constant.
                    ErrorResponse.SECURITY_DESCRIPTION_FIELD_NULL);
        }
        if(productDto.getPolitic().getCancellation().getTitle().isBlank()){
            throw new GeneralProductFieldNullException(Constant.
                    ErrorResponse.CANCELLATION_TITLE_FIELD_NULL);
        }
        if(productDto.getPolitic().getCancellation().getDescription().isBlank()){
            throw new GeneralProductFieldNullException(Constant.
                    ErrorResponse.CANCELLATION_DESCRIPTION_FIELD_NULL);
        }
    }

    public void validateProductsFields(ProductDTO productDto) {
        if(productDto.getTitle().isBlank()){
            throw new GeneralProductFieldNullException(Constant.
                    ErrorResponse.PRODUCT_TITLE_FIELD_NULL);
        }
        if(productDto.getAvailability().isBlank()){
            throw new GeneralProductFieldNullException(Constant.
                    ErrorResponse.PRODUCT_AVAILABILITY_FIELD_NULL);
        }
        if(productDto.getDescription().isBlank()){
            throw new GeneralProductFieldNullException(Constant.
                    ErrorResponse.PRODUCT_DESCRIPTION_FIELD_NULL);
        }
        if(productDto.getTitle().isBlank()){
            throw new GeneralProductFieldNullException(Constant.
                    ErrorResponse.PRODUCT_DESCRIPTION_FIELD_NULL);
        }
        if(productDto.getCity().getName().isBlank()){
            throw new GeneralProductFieldNullException(Constant.
                    ErrorResponse.CITY_NAME_FIELD_NULL);
        }
        if(Objects.isNull(productDto.getCategory().getId())){
            throw new GeneralProductFieldNullException(Constant.
                    ErrorResponse.CATEGORY_ID_FIELD_NULL);
        }

        for(ImageDTO image: productDto.getImages()){
            if(image.getTitle().isBlank()){
                throw new GeneralProductFieldNullException(Constant.
                        ErrorResponse.PRODUCT_IMAGE_NAME_FIELD_NULL);
            }
            if(image.getUrl().isBlank()){
                throw new GeneralProductFieldNullException(Constant.
                        ErrorResponse.PRODUCT_IMAGE_URL_FIELD_NULL);
            }
        }
    }
}

