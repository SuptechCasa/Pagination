package com.uae.pagination.service;

import com.uae.pagination.entities.Product;
import com.uae.pagination.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAllProducts() {
    return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
}
