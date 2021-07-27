package com.cervelBuenTrato.core.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cervelBuenTrato.core.model.TypeBeer;

public interface TypeBeerService {

	public Iterable<TypeBeer> findAll();

	public Page<TypeBeer> findAll(Pageable paginable);

	public Optional<TypeBeer> findById(TypeBeer type);

	public TypeBeer save(TypeBeer type);

	public void deleteById(TypeBeer type);
}
