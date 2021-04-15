package com.sart.market.domain.service;

import com.sart.market.domain.Product;
import com.sart.market.domain.repository.RepoProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private RepoProduct repoProduct;

    public Optional<Product> getProductById(long id) {
        return repoProduct.get(id);
    }

    public Optional<List<Product>> getAllProducts() {
        return repoProduct.getAll();
    }

    public Optional<List<Product>> getAllProductsByCategory(long categoryId) {
        return repoProduct.getByCategory(categoryId);
    }

    public Optional<List<Product>> getAllProductsLessThanStock(int stock) {
        return repoProduct.getLessThan(stock);
    }

    public Product saveProduct(Product product) {
        return repoProduct.save(product);
    }

    public boolean deleteProduct(long id) {
        try {
            repoProduct.delete(id);
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
        return true;
    }

}
