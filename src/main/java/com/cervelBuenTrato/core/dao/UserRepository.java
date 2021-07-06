package com.cervelBuenTrato.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cervelBuenTrato.core.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	// @Query(value = "SELECT u.id_user, u.email, u.username, u.phone, u.password,
	// p.name as profile* FROM User u INNER JOIN Profile p ON u.id_profile =
	// p.id_profile")
	// List<User> findAllWithProfile();

}
