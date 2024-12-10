package com.example.database.Employee;


import java.sql.Date;

import com.example.database.myenum.GenderEnum;

public record employeeUpdateDto(
    Date dob,
    int phoneNumber,
    String address,
    GenderEnum gender,
    String name
    ) {
    
}
