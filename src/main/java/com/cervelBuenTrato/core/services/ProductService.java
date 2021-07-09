package com.cervelBuenTrato.core.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cervelBuenTrato.core.model.Product;

public interface ProductService {

	public Iterable<Product> findAll();

	public Page<Product> findAll(Pageable paginable);

	public Optional<Product> findById(Product prod);

	public Product save(Product prod);

	public void deleteById(Product prod);

}
