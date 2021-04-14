package com.sart.market.persistence.mapper;

import com.sart.market.domain.Product;
import com.sart.market.persistence.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "productName", target = "name"),
            @Mapping(source = "categoryId", target = "categoryId"),
            @Mapping(source = "price", target = "publicPrice"),
            @Mapping(source = "stock", target = "stock"),
            @Mapping(source = "state", target = "isActive"),
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "category", target = "category")
    })
    Product toProduct(ProductEntity productEntity);

    @InheritInverseConfiguration
    @Mapping(target = "barcode", ignore = true)
    ProductEntity toProductEntity(Product product);

}
