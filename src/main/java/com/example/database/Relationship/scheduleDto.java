package com.example.database.Relationship;

import java.time.LocalDateTime;

public record scheduleDto(
    LocalDateTime date,
    int employeeId,
    int shiftId
) {
    
}
