package com.example.database.Employee;

import java.time.LocalDate;
import java.util.Date;

public record employeeUpdateDto(
    LocalDate dob,
    int phoneNumber,
    String address,
    String gender,
    String name,
    String email
) {
    
}
