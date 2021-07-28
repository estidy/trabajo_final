package com.cervelBuenTrato.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cervelBuenTrato.core.model.Snack;

@Repository
public interface SnackRepository extends JpaRepository<Snack, Long> {

}
