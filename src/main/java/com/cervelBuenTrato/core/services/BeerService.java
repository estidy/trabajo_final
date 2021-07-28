package com.cervelBuenTrato.core.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cervelBuenTrato.core.model.Beer;

public interface BeerService {

	public Iterable<Beer> findAll();

	public Page<Beer> findAll(Pageable paginable);

	public Optional<Beer> findById(Beer beer);

	public Beer save(Beer beer);

	public void deleteById(Beer beer);
}
