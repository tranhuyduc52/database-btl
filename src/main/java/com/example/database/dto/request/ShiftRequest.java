package com.example.database.dto.request;

public record ShiftRequest(
    String startTime,
    String endTime,
    float hour
) {
    
}
