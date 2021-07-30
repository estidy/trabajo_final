package com.cervelBuenTrato.core.services;

import com.cervelBuenTrato.core.model.Product;

public interface ProductService {

	public Iterable<Product> nextProductsToExpire();

	public Iterable<Product> productsLessThanStockMin();

}
