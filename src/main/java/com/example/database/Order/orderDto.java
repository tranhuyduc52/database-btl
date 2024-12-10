package com.example.database.Order;

import java.sql.Date;
import java.util.List;

import com.example.database.Product.productInOrderDto;

public record orderDto(
    Date order_time,
    String customerPhoneNumber,
    List<productInOrderDto> producList   //Map<Id,quantity>
) {
    
}
