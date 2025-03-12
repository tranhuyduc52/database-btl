package com.example.database.dto.respone;

import java.sql.Date;

public record ExchangeResponse(
    int quantity,
    Date date,
    String customerName,
    String giftName
) {
    
}
