package com.pi.dh.booking.service.implementations;

import com.pi.dh.booking.dto.*;
import com.pi.dh.booking.exceptions.ReservationNotFoundException;
import com.pi.dh.booking.model.ProductsEntity;
import com.pi.dh.booking.model.ReservationEntity;
import com.pi.dh.booking.model.UserEntity;
import com.pi.dh.booking.repository.IReservationRepository;
import com.pi.dh.booking.service.components.ComponentProduct;
import com.pi.dh.booking.service.interfaces.IReservationService;
import com.pi.dh.booking.util.Constant;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements IReservationService {

    private IReservationRepository reservationRepository;
    private ComponentProduct componentProduct;

    public ReservationServiceImpl(IReservationRepository reservationRepository,
                                  ComponentProduct componentProduct){
        this.reservationRepository = reservationRepository;
        this.componentProduct = componentProduct;
    }

    @Override
    public String createReservation(ReservationDTO reservationDTO) {
        System.out.println("reservationDTO " + reservationDTO.getProduct().getId());
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setHour(reservationDTO.getHour());
        reservationEntity.setStartDate(reservationDTO.getStartDate());
        reservationEntity.setEndDate(reservationDTO.getEndDate());

        ProductsEntity product = new ProductsEntity();
        product.setId(reservationDTO.getProduct().getId());

        reservationEntity.setProducts(product);

        UserEntity user = new UserEntity();
        user.setId(reservationDTO.getUser().getId());

        reservationEntity.setUser(user);

        reservationRepository.save(reservationEntity);

        return Constant.SuccessResponse.RESERVATION_CREATED;
    }

    @Override
    public ReservationDTO findById(int id){
        ReservationEntity reservationEntity = reservationRepository.findById(id).
                orElseThrow(() -> new ReservationNotFoundException(Constant.ErrorResponse.RESERVATION_NOT_FOUND));

        ReservationDTO reservation = new ReservationDTO();

        reservation.setId(reservationEntity.getId());
        reservation.setHour(reservationEntity.getHour());
        reservation.setStartDate(reservationEntity.getStartDate());
        reservation.setEndDate(reservationEntity.getEndDate());

        UserDTO user = new UserDTO();
        user.setId(reservationEntity.getUser().getId());
        user.setName(reservationEntity.getUser().getName());
        user.setLastname(reservationEntity.getUser().getLastname());
        user.setEmail(reservationEntity.getUser().getEmail());
        user.setPassword(reservationEntity.getUser().getPassword());

        CityDTO city = new CityDTO();
        city.setId(reservationEntity.getId());
        city.setName(reservationEntity.getUser().getCity().getName());

        CountryDTO country = new CountryDTO();
        country.setId(reservationEntity.getUser().getCity().getCountry().getId());
        country.setName(reservationEntity.getUser().getCity().getCountry().getName());

        city.setCountry(country);

        user.setCity(city);

        reservation.setUser(user);

        ProductDTO product = componentProduct.mapProductResponse(reservationEntity.getProducts());

        reservation.setProduct(product);

        return reservation;
    }
}
