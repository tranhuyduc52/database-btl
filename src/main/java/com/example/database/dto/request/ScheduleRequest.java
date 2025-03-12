
package com.example.database.dto.request;

import java.sql.Date;

public record ScheduleRequest(
    Date date,
    int employeeId,
    int shiftId
) {
    
}
