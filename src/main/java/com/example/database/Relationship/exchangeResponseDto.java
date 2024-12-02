package com.example.database.Relationship;

import java.time.LocalDateTime;


public record exchangeResponseDto(
    int quantity,
    LocalDateTime date,
    String customerName,
    String giftName
) {
    
}
