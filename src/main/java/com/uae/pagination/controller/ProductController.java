package com.uae.pagination.controller;

import com.uae.pagination.entities.Product;
import com.uae.pagination.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("products")
    public Page<Product> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2")int size,
            @RequestParam(defaultValue = "price")String sortBy,
            @RequestParam(defaultValue = "asc")String direction,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Integer stock
    ){
        return productService.getAllProducts(page, size,sortBy,direction,category,minPrice,maxPrice,stock);
    }

    @PostMapping("products")
    public Product save(@RequestBody Product product){
       return  productService.save(product);
    }

}
