package com.example.database.dto.request;


public record EmployeeUpdateJobRequest(
    String position,
    int unitSalary,
    int id
) {
    
}
