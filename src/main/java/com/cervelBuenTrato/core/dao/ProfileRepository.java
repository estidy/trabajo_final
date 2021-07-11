package com.cervelBuenTrato.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cervelBuenTrato.core.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
