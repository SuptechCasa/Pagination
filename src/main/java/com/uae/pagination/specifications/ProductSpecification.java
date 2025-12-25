package com.uae.pagination.specifications;

import com.uae.pagination.entities.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

    public static Specification<Product> hasCategory(String category){
        return (root,query,cb)->
                category==null?null:cb.equal(root.get("category"),category);
    }

    public static Specification<Product> priceGreaterThan(Double minPrice){
        return (root,query,cb)->
               minPrice==null?null:cb.greaterThan(root.get("price"),minPrice);
    }
    public static Specification<Product> priceLessThan(Double maxPrice){
        return (root,query,cb)->
                maxPrice==null?null:cb.lessThan(root.get("price"),maxPrice);
    }

    public static Specification<Product> stockGreaterThan(Integer stock){
        return (root,query,cb)->
                stock==null?null:cb.greaterThan(root.get("stock"),stock);
    }
}
