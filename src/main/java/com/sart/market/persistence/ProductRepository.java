package com.sart.market.persistence;


import com.sart.market.domain.Product;
import com.sart.market.domain.repository.RepoProduct;
import com.sart.market.persistence.crud.ProductCrud;
import com.sart.market.persistence.entity.ProductEntity;
import com.sart.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class ProductRepository implements RepoProduct {

    @Autowired
    private ProductCrud crud;

    @Autowired
    private ProductMapper mapper;

    @Override
    public Optional<Product> get(long id) {
        return this.selectById(id).map(p -> mapper.toProduct(p));
    }

    @Override
    public Optional<List<Product>> getAll() {
        return Optional.of(StreamSupport.stream(this.selectAll().spliterator(), false)
                .map(e -> mapper.toProduct(e))
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<List<Product>> getByCategory(long categoryId) {
        return this.selectByCategory(categoryId).map(ps -> mapper.toProducts(ps));
    }

    @Override
    public Optional<List<Product>> getLessThan(int quantity) {
        return this.selectByStockLessThan(quantity).map(ps -> mapper.toProducts(ps));
    }

    @Override
    public Product save(Product product) {
        return mapper.toProduct(this.insertOrUpdate(mapper.toProductEntity(product)));
    }

    @Override
    public void delete(long id) {
        this.deleteById(id);
    }

    private Optional<ProductEntity> selectById(Long id) {
        return crud.findById(id);
    }

    private Iterable<ProductEntity> selectAll() {
        return crud.findAll();
    }

    private Optional<List<ProductEntity>> selectByCategory(Long categoryId) {
        return crud.findByCategoryId(categoryId);
    }

    private Optional<List<ProductEntity>> selectByStockLessThan(int stock) {
        return crud.findByStockLessThanAndState(stock, true);
    }

    private ProductEntity insertOrUpdate(ProductEntity product) {
        return crud.save(product);
    }

    private void deleteById(Long id) {
        crud.deleteById(id);
    }
}
