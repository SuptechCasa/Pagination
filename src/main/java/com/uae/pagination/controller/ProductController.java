package com.uae.pagination.controller;

import com.uae.pagination.entities.Product;
import com.uae.pagination.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("products")
    public List<Product> findAll(){
        return productService.getAllProducts();
    }

    @PostMapping("products")
    public Product save(@RequestBody Product product){
       return  productService.save(product);
    }

}
