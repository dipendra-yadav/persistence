package com.persistence.multiple.dao.product;

import org.springframework.data.jpa.repository.JpaRepository;

import com.persistence.multiple.model.product.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
