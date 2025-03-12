package com.example.database.dto.respone;


import java.sql.Date;


public record EmployeeResponse(
    int id,
    String name,
    String phoneNumber,
    Date startDate,
    String position,
    int totalSalary
) {
    
}
