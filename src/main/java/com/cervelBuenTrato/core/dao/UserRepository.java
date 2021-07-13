package com.cervelBuenTrato.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cervelBuenTrato.core.model.Usr;

@Repository
public interface UserRepository extends JpaRepository<Usr, Long> {

	Usr findByUsername(String username);

}
