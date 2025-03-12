package com.example.database.dto.request;

import java.sql.Date;

public record ExchangeRequest(
    int giftId,
    int quantity,
    Date date
) {
    
}
