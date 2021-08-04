package com.cervelBuenTrato.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cervelBuenTrato.core.dto.ProductDto;
import com.cervelBuenTrato.core.model.Snack;

@Repository
public interface SnackRepository extends JpaRepository<Snack, Long> {
	@Query(nativeQuery = true, value = "SELECT p.id_product, p.dtype as type_prod, p.description, p.expiration, p.name, p.price, p.stock_actual, p.stock_min, s.grams as grams, DATEDIFF(p.expiration, CURDATE()) as dias_venc FROM product p INNER JOIN size s ON s.id_size = p.id_size WHERE DATEDIFF(p.expiration, CURDATE()) <= 90 AND p.stock_actual > 0 p.dtype = 'SNACK'")
	List<ProductDto> nextProductsToExpire();
}
