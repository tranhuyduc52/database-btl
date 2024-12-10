package com.example.database.Employee;


import java.sql.Date;


public record employeeUpdateDto(
    Date dob,
    String phoneNumber,
    String address,
    char gender,
    String name
    ) {
    
}
