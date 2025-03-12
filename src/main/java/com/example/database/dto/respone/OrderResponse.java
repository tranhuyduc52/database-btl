package com.example.database.dto.respone;

import java.sql.Date;
import java.util.List;

public record OrderResponse(
    int id,
    float total_charge,
    Date order_time,
    String employeeName,
    String customerName,
    List<ProductInOrderResponse> producList
) {
    
}
