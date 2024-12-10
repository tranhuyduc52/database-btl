package com.example.database.Order;

import java.sql.Date;
import java.util.List;


import com.example.database.Product.productInOrderResponseDto;

public record orderResponseDto(
    int id,
    float total_charge,
    Date order_time,
    String employeeName,
    String customerName,
    List<productInOrderResponseDto> producList
) {
    
}
