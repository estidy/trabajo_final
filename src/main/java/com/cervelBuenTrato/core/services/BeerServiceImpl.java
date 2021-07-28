package com.cervelBuenTrato.core.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cervelBuenTrato.core.dao.BeerRepository;
import com.cervelBuenTrato.core.model.Beer;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {

	@Autowired
	private BeerRepository beerRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Beer> findAll() {
		return beerRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Beer> findAll(Pageable paginable) {
		return beerRepository.findAll(paginable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Beer> findById(Beer beer) {
		return beerRepository.findById(beer.getId_product());
	}

	@Override
	@Transactional
	public Beer save(Beer beer) {
		return beerRepository.save(null);
	}

	@Override
	@Transactional
	public void deleteById(Beer beer) {
		beerRepository.deleteById(beer.getId_product());

	}

}
