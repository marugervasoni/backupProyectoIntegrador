package com.pi.dh.booking.repository;

import com.pi.dh.booking.model.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICityRepository extends JpaRepository<CityEntity, Integer> {

    @Query(value = "SELECT c.id FROM city c WHERE c.name =:name",
    nativeQuery = true)
    Integer findByName(String name);
}
