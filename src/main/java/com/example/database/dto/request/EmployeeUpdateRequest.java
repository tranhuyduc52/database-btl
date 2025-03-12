package com.example.database.dto.request;


import java.sql.Date;


public record EmployeeUpdateRequest(
    Date dob,
    String phoneNumber,
    String address,
    char gender,
    String name
    ) {
    
}
