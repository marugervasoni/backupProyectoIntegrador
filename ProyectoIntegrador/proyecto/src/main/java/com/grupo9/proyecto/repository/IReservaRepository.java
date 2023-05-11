package com.grupo9.proyecto.repository;

import com.grupo9.proyecto.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservaRepository extends JpaRepository<Reserva, Integer> {

}
