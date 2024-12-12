package com.example.database.revenue;

public record RevenueResponseDto(
    int productId,
    String productName,
    float productPrice,
    int quantity,
    float totalRevenue
) {
}
