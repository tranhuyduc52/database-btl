package com.example.database.mapper;

import org.springframework.stereotype.Service;

import com.example.database.dto.request.ShiftRequest;
import com.example.database.dto.respone.ShiftResponse;
import com.example.database.model.Shift;

@Service
public class ShiftMapper {
    public Shift tShift(ShiftRequest dto){
        var shift = new Shift();
        shift.setEndTime(dto.endTime());
        shift.setStartTime(dto.startTime());
        shift.setHour(dto.hour());
        return shift;
    }
    public ShiftResponse tShiftResponseDto(Shift shift){
        return new ShiftResponse(shift.getId(),shift.getStartTime(), shift.getEndTime());
    }
}
