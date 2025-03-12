package com.example.database.mapper;

import org.springframework.stereotype.Service;

import com.example.database.dto.request.ProductRequest;
import com.example.database.dto.respone.ProductResponse;
import com.example.database.model.Product;

@Service
public class ProductMapper {
    public Product tProduct(ProductRequest dto){
        var product=new Product();
        product.setName(dto.name());
        product.setUnit_price(dto.unit_price());
        product.setAvailable(true);
        product.setDiscount(0);
        return product;
    }
    public ProductResponse toProductResponseDto(Product product){
        var productResponseDto=new ProductResponse(product.getName(),product.getUnit_price(),product.getDiscount(),product.getRating(),product.getDescription(),product.getId());
        return productResponseDto;
    }
}
