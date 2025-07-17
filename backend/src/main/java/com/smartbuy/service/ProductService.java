package com.smartbuy.service;

import com.smartbuy.model.Product;
import com.smartbuy.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepo;
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }
    public Product saveProduct(Product product){
        return productRepo.save(product);
    }
    public  Product getProductById(Long id){
        return productRepo.findById(id).orElse(null);
    }
    public void deleteProduct(Long id){
        productRepo.deleteById(id);
    }
    public Product update(Long id, Product updated) {
        Product existing = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        existing.setName(updated.getName());
        existing.setDescription(updated.getDescription());
        existing.setPrice(updated.getPrice());
        existing.setImageUrl(updated.getImageUrl());
        return productRepo.save(existing);
    }
}
