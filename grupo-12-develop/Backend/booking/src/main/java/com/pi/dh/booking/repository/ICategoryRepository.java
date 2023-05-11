package com.pi.dh.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pi.dh.booking.model.CategoryEntity;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}
