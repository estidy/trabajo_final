package com.cervelBuenTrato.core.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cervelBuenTrato.core.model.Snack;

public interface SnackService {

	public Iterable<Snack> findAll();

	public Page<Snack> findAll(Pageable paginable);

	public Optional<Snack> findById(Snack snack);

	public Snack save(Snack snack);

	public void deleteById(Snack snack);
}
