package com.example.database.Employee;

import java.util.Date;

public record employeeResponseDto(
    int id,
    String name,
    int phoneNumber,
    Date startDate,
    String position,
    int unitSalary
) {
    
}
