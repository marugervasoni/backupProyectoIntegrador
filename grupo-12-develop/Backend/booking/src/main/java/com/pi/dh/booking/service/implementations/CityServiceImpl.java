package com.pi.dh.booking.service.implementations;

import com.pi.dh.booking.dto.CityDTO;
import com.pi.dh.booking.dto.CountryDTO;
import com.pi.dh.booking.exceptions.CityNotFoundException;
import com.pi.dh.booking.model.CityEntity;
import com.pi.dh.booking.repository.ICityRepository;
import com.pi.dh.booking.service.interfaces.ICityService;
import com.pi.dh.booking.util.Constant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements ICityService {

    private ICityRepository cityRepository;

    public CityServiceImpl(ICityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    @Override
    public List<CityDTO> findAll() {

        List<CityEntity> cities = cityRepository.findAll();

        if(cities.isEmpty()){
            throw new CityNotFoundException(Constant.ErrorResponse.CITY_NOT_FOUND);
        }

        List<CityDTO> listCities = new ArrayList<>();
        for(CityEntity city: cities){
           CityDTO cityDto = new CityDTO();
           cityDto.setId(city.getId());
           cityDto.setName(city.getName());

           CountryDTO countryDto = new CountryDTO();
           countryDto.setId(city.getCountry().getId());
           countryDto.setName(city.getCountry().getName());

           cityDto.setCountry(countryDto);

           listCities.add(cityDto);
        }

        return listCities;
    }
}
