package com.example.database.Relationship;

import java.time.LocalDateTime;

public record exchangeDto(
    int giftId,
    int quantity,
    LocalDateTime date
) {
    
}
