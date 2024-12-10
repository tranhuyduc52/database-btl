package com.example.database.Employee;

import com.example.database.myenum.PositionEnum;

public record employeeUpdateJobDto(
    PositionEnum position,
    int unitSalary,
    int id
) {
    
}
