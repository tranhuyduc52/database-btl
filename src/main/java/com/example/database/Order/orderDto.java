package com.example.database.Order;

import java.time.LocalDateTime;
import java.util.List;

import com.example.database.Product.productInOrderDto;

public record orderDto(
    String payment_method,
    LocalDateTime order_time,
    String customer_username,
    List<productInOrderDto> producList   //Map<Id,quantity>
) {
    
}
