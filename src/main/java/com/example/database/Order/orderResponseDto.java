package com.example.database.Order;

import java.time.LocalDateTime;
import java.util.List;

import com.example.database.Customer.customerResponseDTO;
import com.example.database.Employee.employeeResponseDto;
import com.example.database.Product.productInOrderResponseDto;

public record orderResponseDto(
    int id,
    int total_charge,
    String payment_method,
    LocalDateTime order_time,
    String employeeName,
    String customerName,
    List<productInOrderResponseDto> producList
) {
    
}
