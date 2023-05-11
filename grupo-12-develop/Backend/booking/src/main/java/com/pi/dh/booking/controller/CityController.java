package com.pi.dh.booking.controller;

import com.pi.dh.booking.dto.CityDTO;
import com.pi.dh.booking.dto.ResponseDTO;
import com.pi.dh.booking.service.implementations.CityServiceImpl;
import com.pi.dh.booking.util.Constant;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Constant.Endpoints.CITIES)
public class CityController {

    private CityServiceImpl cityService;

    public CityController(CityServiceImpl cityService){
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseDTO<List<CityDTO>> findAll(){
        List<CityDTO> response = cityService.findAll();

        return new ResponseDTO<>(HttpStatus.OK.value(),
                Constant.SuccessResponse.GET_ALL_CITIES, response);
    }
}
