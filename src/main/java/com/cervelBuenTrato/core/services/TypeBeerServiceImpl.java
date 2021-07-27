package com.cervelBuenTrato.core.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cervelBuenTrato.core.dao.TypeBeerRepository;
import com.cervelBuenTrato.core.model.TypeBeer;

@Service
public class TypeBeerServiceImpl implements TypeBeerService {
	@Autowired
	TypeBeerRepository typeBeerRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<TypeBeer> findAll() {
		return typeBeerRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<TypeBeer> findAll(Pageable paginable) {
		return typeBeerRepository.findAll(paginable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<TypeBeer> findById(TypeBeer type) {
		return typeBeerRepository.findById(type.getId_type_beer());
	}

	@Override
	@Transactional
	public TypeBeer save(TypeBeer type) {
		return typeBeerRepository.save(type);
	}

	@Override
	@Transactional
	public void deleteById(TypeBeer type) {
		typeBeerRepository.delete(type);

	}

}
