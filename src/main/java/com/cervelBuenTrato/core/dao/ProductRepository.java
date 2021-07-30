package com.cervelBuenTrato.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cervelBuenTrato.core.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(nativeQuery = true, value = "SELECT p.* FROM product p WHERE DATEDIFF(p.expiration, CURDATE()) <= 90 AND p.stock_actual > 0")
	List<Product> nextProductsToExpire();

	@Query(nativeQuery = true, value = "SELECT p.* FROM product p WHERE p.stock_actual <= p.stock_min")
	List<Product> productsLessThanStockMin();
}
