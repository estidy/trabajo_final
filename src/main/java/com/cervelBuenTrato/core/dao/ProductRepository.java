package com.cervelBuenTrato.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cervelBuenTrato.core.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
