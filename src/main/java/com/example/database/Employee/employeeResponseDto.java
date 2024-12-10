package com.example.database.Employee;


import java.sql.Date;

import com.example.database.myenum.PositionEnum;

public record employeeResponseDto(
    int id,
    String name,
    String phoneNumber,
    Date startDate,
    PositionEnum position,
    int unitSalary
) {
    
}
