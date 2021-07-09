package com.cervelBuenTrato.core.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cervelBuenTrato.core.dao.UserRepository;
import com.cervelBuenTrato.core.model.Profile;
import com.cervelBuenTrato.core.model.Usr;

import lombok.extern.slf4j.Slf4j;

@Service("UserDetailsService")
@Slf4j
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usr user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		var profiles = new ArrayList<GrantedAuthority>();
		for (Profile profile : user.getProfiles()) {
			profiles.add(new SimpleGrantedAuthority(profile.getName()));
		}
		return new User(user.getUsername(), user.getPassword(), profiles);
	}

	@Transactional(readOnly = true)
	public Iterable<Usr> findAll() {
		return userRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Page<Usr> findAll(Pageable paginable) {
		return userRepository.findAll(paginable);
	}

	@Transactional(readOnly = true)
	public Optional<Usr> findById(Usr user) {
		return userRepository.findById(user.getId_user());
	}

	@Transactional
	public Usr save(Usr user) {
		return userRepository.save(user);
	}

	@Transactional
	public void deleteById(Usr user) {
		userRepository.deleteById(user.getId_user());
	}
}
