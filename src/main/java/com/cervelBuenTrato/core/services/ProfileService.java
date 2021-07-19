package com.cervelBuenTrato.core.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cervelBuenTrato.core.dao.ProfileRepository;
import com.cervelBuenTrato.core.model.Profile;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository profileRepository;

	@Transactional(readOnly = true)
	public Iterable<Profile> findAll() {
		return profileRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Page<Profile> findAll(Pageable paginable) {
		return profileRepository.findAll(paginable);
	}

	@Transactional(readOnly = true)
	public Optional<Profile> findById(Long id) {
		return profileRepository.findById(id);
	}

	@Transactional
	public Profile save(Profile prof) {
		return profileRepository.save(prof);
	}

	@Transactional
	public void deleteById(Profile prof) {
		profileRepository.deleteById(prof.getId_profile());
	}

	@Transactional(readOnly = true)
	public Profile findByName(String name) {
		return (profileRepository.findByName(name));
	}

}
