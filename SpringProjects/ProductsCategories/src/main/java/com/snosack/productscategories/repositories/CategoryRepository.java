package com.snosack.productscategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.snosack.productscategories.models.Category;
import com.snosack.productscategories.models.Product;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAllByProducts(Product product);
    List<Category> findByProductsNotContains(Product product);
}