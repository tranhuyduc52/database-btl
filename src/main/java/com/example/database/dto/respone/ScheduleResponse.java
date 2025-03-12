package com.example.database.dto.respone;

import java.sql.Date;
import java.time.LocalDateTime;

import com.example.database.model.ScheduleEmbed;

public record ScheduleResponse(
    ScheduleEmbed id,
    Date date,
    String employeeName,
    ShiftResponse shiftResponseDto
) {
    
}
