package com.sart.market.web.controller;

import com.sart.market.domain.Product;
import com.sart.market.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    @ApiOperation("Find product by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "NOT_FOUND"),
    })
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id) {
        return productService.getProductById(id)
                .map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        return productService.getAllProducts()
                .map(lp -> new ResponseEntity<>(lp, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> getAllProductsByCategory(@PathVariable("categoryId") long categoryId) {
        return productService.getAllProductsByCategory(categoryId).orElseThrow();
    }

    @GetMapping(params = "maxStock")
    public List<Product> getAllProductsLessThanStock(int maxStock) {
        return productService.getAllProductsLessThanStock(maxStock).orElseThrow();
    }

    @PostMapping()
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteProduct(@PathVariable("id") long id) {
        return productService.deleteProduct(id);
    }

}
