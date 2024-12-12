package com.example.database.revenue;

import java.util.List;

public record TotalRevenueResponseDto(
    List<RevenueResponseDto> revenueResponseDto,
    float totalRevenue
) {
    
}
