package com.example.database.Relationship;

import java.sql.Date;
import java.time.LocalDateTime;

public record scheduleDto(
    Date date,
    int employeeId,
    int shiftId
) {
    
}
