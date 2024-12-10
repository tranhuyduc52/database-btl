package com.example.database.Product;

public record productResponseDto(
    String name,
    float unit_price,
    int discount,
    float rating,
    String description,
    int id
) {
    
}
