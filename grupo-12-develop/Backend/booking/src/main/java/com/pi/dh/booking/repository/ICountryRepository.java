package com.pi.dh.booking.repository;

import com.pi.dh.booking.model.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICountryRepository extends JpaRepository<CountryEntity, Integer> {

    @Query(value = "SELECT c.id FROM country c WHERE c.name =:name Limit 1",
            nativeQuery = true)
    Integer findByName(String name);

}
