package com.pi.dh.booking.service.interfaces;

import com.pi.dh.booking.dto.ReservationDTO;
import com.pi.dh.booking.model.ReservationEntity;

import java.util.List;

public interface IReservationService {

    String createReservation(ReservationDTO reservationDTO);

    ReservationDTO findById(int id);
}
