package com.cervelBuenTrato.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cervelBuenTrato.core.model.Beer;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Long> {
}
