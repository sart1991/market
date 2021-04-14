package com.sart.market.persistence;


import com.sart.market.persistence.crud.ProductCrud;
import com.sart.market.persistence.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class ProductRepository {

    private ProductCrud crud;

    public Optional<Product> selectById(Long id) {
        return crud.findById(id);
    }

    public List<Product> selectAll() {
        return StreamSupport.stream(crud.findAll().spliterator(), false)
                            .collect(Collectors.toList());
    }

    public List<Product> selectByCategory(Long categoryId) {
        return crud.findByCategoryId(categoryId);
    }

    public Optional<List<Product>> selectByStockLessThan(int stock) {
        return crud.findByStockLessThanAndState(stock, true);
    }

    public Product insert(Product product) {
        return crud.save(product);
    }

    public void deleteById(Long id) {
        crud.deleteById(id);
    }

}