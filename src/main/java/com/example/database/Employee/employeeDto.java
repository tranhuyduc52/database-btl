package com.example.database.Employee;

import com.example.database.myenum.PositionEnum;

public record employeeDto(
    int unitSalary,
    PositionEnum position,
    int phoneNumber,
    String password
) {
    
}
