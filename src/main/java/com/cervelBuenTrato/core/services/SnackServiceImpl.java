package com.cervelBuenTrato.core.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cervelBuenTrato.core.dao.SnackRepository;
import com.cervelBuenTrato.core.model.Snack;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SnackServiceImpl implements SnackService {

	@Autowired
	private SnackRepository snackRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Snack> findAll() {
		return snackRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Snack> findAll(Pageable paginable) {
		return snackRepository.findAll(paginable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Snack> findById(Snack snack) {
		return snackRepository.findById(snack.getId_product());
	}

	@Override
	@Transactional
	public Snack save(Snack snack) {
		return snackRepository.save(snack);
	}

	@Override
	@Transactional
	public void deleteById(Snack snack) {
		snackRepository.deleteById(snack.getId_product());
		;

	}

}
