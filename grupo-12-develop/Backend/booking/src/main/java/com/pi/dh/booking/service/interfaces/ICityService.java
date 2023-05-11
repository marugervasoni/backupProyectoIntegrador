package com.pi.dh.booking.service.interfaces;

import com.pi.dh.booking.dto.CityDTO;
import com.pi.dh.booking.model.CityEntity;

import java.util.List;

public interface ICityService {

    List<CityDTO> findAll();
}
