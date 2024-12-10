package com.example.database.Customer;

import java.sql.Date;

import com.example.database.myenum.GenderEnum;

public record customerUpdateDto(
    Date dob,
    int phoneNumber,
    String address,
    GenderEnum gender,
    String name) {
    
}
