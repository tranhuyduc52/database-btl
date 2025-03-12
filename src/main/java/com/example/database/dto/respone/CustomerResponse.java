package com.example.database.dto.respone;

public record CustomerResponse(
    int id,
    String name,
    String address,
    String phoneNumber) {
    
}
