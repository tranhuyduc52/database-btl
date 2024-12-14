package com.example.database.Product;

import org.springframework.stereotype.Service;

@Service
public class productMapper {
    public product tProduct(productDto dto){
        var product=new product();
        product.setName(dto.name());
        product.setUnit_price(dto.unit_price());
        product.setAvailable(true);
        product.setDiscount(0);
        return product;
    }
    public productResponseDto toProductResponseDto(product product){
        var productResponseDto=new productResponseDto(product.getName(),product.getUnit_price(),product.getDiscount(),product.getRating(),product.getDescription(),product.getId());
        return productResponseDto;
    }
}
