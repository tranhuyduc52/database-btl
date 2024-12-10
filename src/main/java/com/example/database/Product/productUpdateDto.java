package com.example.database.Product;

public record productUpdateDto(
    String name,
    float unit_price,
    int discount,
    int id
    ) 
    {
    
}
