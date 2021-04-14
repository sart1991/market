package com.sart.market.persistence.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "purchases_products")
public class ProductsPurchase {

    @EmbeddedId
    private ProductsPurchasePK id;

    @Column
    private Integer quantity;

    @Column
    private BigDecimal total;

    @Column
    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "purchase_id", insertable = false, updatable = false)
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    public ProductsPurchasePK getId() {
        return id;
    }

    public void setId(ProductsPurchasePK id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public Product getProduct() {
        return product;
    }
}
