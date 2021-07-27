package com.cervelBuenTrato.core.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cervelBuenTrato.core.model.Size;

public interface SizeService {
	public Iterable<Size> findAll();

	public Page<Size> findAll(Pageable paginable);

	public Optional<Size> findById(Size size);

	public Size save(Size size);

	public void deleteById(Size size);
}
