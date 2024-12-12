package com.example.database.Relationship;

import java.sql.Date;

public record scheduleDto(
    Date date,
    int employeeId,
    int shiftId
) {
    
}
