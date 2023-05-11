package com.pi.dh.booking.repository;

import com.pi.dh.booking.model.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservationRepository extends JpaRepository<ReservationEntity, Integer> {

}
