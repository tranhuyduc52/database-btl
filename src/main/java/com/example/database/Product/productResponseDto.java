package com.example.database.Product;

public record productResponseDto(
    String name,
    int unit_price,
    int discount,
    float rating,
    String description,
    int id
) {
    
}
