package com.example.database.Customer;

import java.time.LocalDate;

public record customerUpdateDto(
    LocalDate dob,
    int phoneNumber,
    String address,
    String gender,
    String name,
    String email
) {
    
}
