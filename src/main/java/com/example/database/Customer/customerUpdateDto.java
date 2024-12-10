package com.example.database.Customer;

import java.sql.Date;

import com.example.database.myenum.GenderEnum;

public record customerUpdateDto(
    Date dob,
    String phoneNumber,
    String address,
    GenderEnum gender,
    String name) {
    
}
