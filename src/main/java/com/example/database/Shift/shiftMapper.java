package com.example.database.Shift;

import org.springframework.stereotype.Service;

@Service
public class shiftMapper {
    public shift tShift(shiftDto dto){
        var shift = new shift();
        shift.setEndTime(dto.endTime());
        shift.setStartTime(dto.startTime());
        return shift;
    }
    public shiftResponseDto tShiftResponseDto(shift shift){
        return new shiftResponseDto(shift.getId(),shift.getStartTime(), shift.getEndTime());
    }
}
