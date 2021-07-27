package com.cervelBuenTrato.core.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cervelBuenTrato.core.dao.ProductRepository;
import com.cervelBuenTrato.core.model.Product;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Product> findAll(Pageable paginable) {
		return productRepository.findAll(paginable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Product> findById(Product prod) {
		return productRepository.findById(prod.getId_product());
	}

	@Override
	@Transactional
	public Product save(Product prod) {
		return productRepository.save(prod);
	}

	@Override
	@Transactional
	public void deleteById(Product prod) {
		productRepository.deleteById(prod.getId_product());
	}

}
