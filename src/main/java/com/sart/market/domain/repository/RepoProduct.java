package com.sart.market.domain.repository;

import com.sart.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface RepoProduct {

    Optional<Product> get(long id);
    Optional<List<Product>> getAll();
    Optional<List<Product>> getByCategory(long categoryId);
    Optional<List<Product>> getLessThan(int quantity);
    Product save(Product product);
    void delete(long id);

}
