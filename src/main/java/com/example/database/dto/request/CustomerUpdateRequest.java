package com.example.database.dto.request;

import java.sql.Date;


public record CustomerUpdateRequest(
    Date dob,
    String phoneNumber,
    String address,
    char gender,
    String name) {
    
}
