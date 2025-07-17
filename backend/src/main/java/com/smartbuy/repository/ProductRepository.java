package com.smartbuy.repository;

import com.smartbuy.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
