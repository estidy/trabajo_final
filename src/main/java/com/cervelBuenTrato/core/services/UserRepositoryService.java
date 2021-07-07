package com.cervelBuenTrato.core.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cervelBuenTrato.core.model.User;

public interface UserRepositoryService {

	public Iterable<User> findAll();

	public Iterable<User> findAllWithProfile();

	public Page<User> findAll(Pageable paginable);

	public Optional<User> findById(User user);

	public User save(User user);

	public void deleteById(User user);

}
