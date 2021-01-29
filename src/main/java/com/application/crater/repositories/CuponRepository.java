package com.application.crater.repositories;

import com.application.crater.entities.Cupon;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CuponRepository extends JpaRepository<Cupon, Long> {
    
}
