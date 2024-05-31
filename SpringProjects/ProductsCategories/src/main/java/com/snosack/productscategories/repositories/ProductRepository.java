package com.snosack.productscategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.snosack.productscategories.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll(Product product);
}