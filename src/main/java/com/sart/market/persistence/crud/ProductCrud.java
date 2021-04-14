package com.sart.market.persistence.crud;

import com.sart.market.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrud extends CrudRepository<ProductEntity, Long> {

    @Query(value = "SELECT * FROM products p WHERE category_id = ?", nativeQuery = true)
    List<ProductEntity> findByCategoryId(Long categoryId);

    Optional<List<ProductEntity>> findByStockLessThanAndState(int stock, boolean state);

}
