package com.cervelBuenTrato.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cervelBuenTrato.core.dao.ProductRepository;
import com.cervelBuenTrato.core.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Product> nextProductsToExpire() {
		return productRepository.nextProductsToExpire();
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Product> productsLessThanStockMin() {
		return productRepository.productsLessThanStockMin();
	}
}
