package com.pi.dh.booking.exceptions;

public class ReservationNotFoundException extends RuntimeException{

    public ReservationNotFoundException(String message){
        super(message);
    }
}
