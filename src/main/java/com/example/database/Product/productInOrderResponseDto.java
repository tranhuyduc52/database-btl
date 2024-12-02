package com.example.database.Product;

public record productInOrderResponseDto(
    productResponseDto productResponseDto,
    int quantity
) {
    
}
