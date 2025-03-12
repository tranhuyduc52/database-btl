package com.example.database.dto.request;

public record ProductInOrderRequest(
    int productId,
    int quantity
) {
    
}
