package com.sart.market.persistence.mapper;

import com.sart.market.domain.Product;
import com.sart.market.persistence.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "productName"),
            @Mapping(source = "categoryId", target = "categoryId"),
            @Mapping(source = "publicPrice", target = "price"),
            @Mapping(source = "stock", target = "stock"),
            @Mapping(source = "state", target = "active"),
            @Mapping(source = "category", target = "category")
    })
    Product toProduct(ProductEntity productEntity);

    List<Product> toProducts(List<ProductEntity> products);

    @InheritInverseConfiguration
    @Mapping(target = "barcode", ignore = true)
    ProductEntity toProductEntity(Product product);

}
