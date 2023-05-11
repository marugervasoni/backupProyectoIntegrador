package com.pi.dh.booking.controller;

import com.pi.dh.booking.dto.ReservationDTO;
import com.pi.dh.booking.dto.ResponseDTO;
import com.pi.dh.booking.service.interfaces.IReservationService;
import com.pi.dh.booking.util.Constant;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constant.Endpoints.RESERVATION)
public class ReservationController {

    private IReservationService reservationService;

    public ReservationController(IReservationService reservationService){
        this.reservationService = reservationService;
    }

    @PostMapping(value=Constant.Endpoints.CREATE_RESERVATION, produces="application/json")
    public ResponseDTO<String> createReservation(@RequestBody ReservationDTO reservationDto){

        String message = reservationService.createReservation(reservationDto);

        return new ResponseDTO<>(HttpStatus.OK.value(), message);
    }

    @GetMapping(value=Constant.Endpoints.GET_RESERVATION_BY_ID, produces="application/json")
    public ResponseDTO<ReservationDTO> findReservationById(@PathVariable int id){

        ReservationDTO response = reservationService.findById(id);

        return new ResponseDTO<>(HttpStatus.OK.value(),
                Constant.SuccessResponse.GET_RESERVATION_BY_ID, response);
    }
}
