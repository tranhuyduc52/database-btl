
package com.example.database.dto.request;

public record ProductUpdateRequest(
    String name,
    float unit_price,
    int discount,
    int id
    ) 
    {
    
}
