package com.cervelBuenTrato.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cervelBuenTrato.core.model.TypeBeer;

@Repository
public interface TypeBeerRepository extends JpaRepository<TypeBeer, Long> {

}
