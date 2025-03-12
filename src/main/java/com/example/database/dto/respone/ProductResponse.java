package com.example.database.dto.respone;

public record ProductResponse(
    String name,
    float unit_price,
    int discount,
    float rating,
    String description,
    int id
) {
    
}
