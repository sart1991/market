package com.sart.market.persistence.crud;

import com.sart.market.persistence.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrud extends CrudRepository<Product, Long> {

    @Query(value = "SELECT * FROM products p WHERE category_id = ?", nativeQuery = true)
    List<Product> findByCategoryId(Long categoryId);

    Optional<List<Product>> findByStockLessThanAndState(int stock, boolean state);

}
