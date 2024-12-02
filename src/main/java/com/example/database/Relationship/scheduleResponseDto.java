package com.example.database.Relationship;

import java.time.LocalDateTime;

import com.example.database.Embedded.schedule_embed;
import com.example.database.Shift.shiftResponseDto;

public record scheduleResponseDto(
    schedule_embed id,
    LocalDateTime date,
    String employeeName,
    shiftResponseDto shiftResponseDto
) {
    
}
