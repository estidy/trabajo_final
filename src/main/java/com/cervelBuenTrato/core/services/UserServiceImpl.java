package com.cervelBuenTrato.core.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cervelBuenTrato.core.dao.UserRepository;
import com.cervelBuenTrato.core.model.User;

@Service
public class UserServiceImpl implements UserRepositoryService {

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Page<User> findAll(Pageable paginable) {
		return userRepository.findAll(paginable);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<User> findById(User user) {
		return userRepository.findById(user.getId_user());
	}

	@Transactional
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Transactional
	@Override
	public void deleteById(User user) {
		userRepository.deleteById(user.getId_user());
	}

}
