package com.uae.pagination.service;

import com.uae.pagination.entities.Product;
import com.uae.pagination.repository.ProductRepository;
import com.uae.pagination.specifications.ProductSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Page<Product> getAllProducts(int page, int size, String sortBy, String direction,
                                        String category,
                                        Double minPrice,
                                        Double maxPrice,
                                        Integer stock
                                        ) {
        Sort sort = direction.equalsIgnoreCase("desc")?
                Sort.by(sortBy).descending():Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);

        Specification<Product> specification=Specification
                .where(ProductSpecification.hasCategory(category))
                .and(ProductSpecification.priceGreaterThan(minPrice))
                .and(ProductSpecification.priceLessThan(maxPrice))
                .and(ProductSpecification.stockGreaterThan(stock));

    return productRepository.findAll(specification,pageable);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
}
