package com.cervelBuenTrato.core.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cervelBuenTrato.core.dao.SizeRepository;
import com.cervelBuenTrato.core.model.Size;

@Service
public class SizeServiceImpl implements SizeService {

	@Autowired
	SizeRepository sizeRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Size> findAll() {
		return sizeRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Size> findAll(Pageable paginable) {
		return sizeRepository.findAll(paginable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Size> findById(Size size) {
		return sizeRepository.findById(size.getId_size());
	}

	@Override
	@Transactional
	public Size save(Size size) {
		return sizeRepository.save(size);
	}

	@Override
	@Transactional
	public void deleteById(Size size) {
		sizeRepository.delete(size);

	}

}
