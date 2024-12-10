package com.example.database.Relationship;

import java.sql.Date;

public record exchangeResponseDto(
    int quantity,
    Date date,
    String customerName,
    String giftName
) {
    
}
