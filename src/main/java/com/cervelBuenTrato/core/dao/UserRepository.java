package com.cervelBuenTrato.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cervelBuenTrato.core.model.Usr;

@Repository
public interface UserRepository extends JpaRepository<Usr, Long> {

	Usr findByUsername(String username);

	Usr findByEmail(String email);

	@Query(nativeQuery = true, value = "SELECT u.* FROM usr u WHERE DATEDIFF(CURDATE(),u.date_account) <= 2 AND u.active = 1")
	List<Usr> newUsersRegister();

}
