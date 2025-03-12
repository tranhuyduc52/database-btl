
package com.example.database.dto.request;


public record EmployeeRequest(
    int unitSalary,
    String position,
    String phoneNumber,
    String password
) {
    
}
