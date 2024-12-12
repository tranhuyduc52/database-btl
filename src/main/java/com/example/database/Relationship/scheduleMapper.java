package com.example.database.Relationship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.Repository.employeeRepo;
import com.example.database.Repository.shiftRepo;
import com.example.database.Shift.shiftMapper;

@Service
public class scheduleMapper {
    @Autowired
    private employeeRepo employeeRepo;
    @Autowired
    private shiftRepo shiftRepo;
    @Autowired
    private shiftMapper shiftMapper;
    public schedule tSchedule(scheduleDto dto){
        var schedule = new schedule();
        schedule.getId().setDate(dto.date());
        employeeRepo.findById(dto.employeeId()).orElse(null).addSchedule(schedule);
        shiftRepo.findById(dto.shiftId()).orElse(null).addSchedule(schedule);
        return schedule;
    }
    public scheduleResponseDto tScheduleResponseDto(schedule schedule){
        return new scheduleResponseDto(schedule.getId(),schedule.getId().getDate(),schedule.getEmployee().getName(),shiftMapper.tShiftResponseDto( schedule.getShift()));
    }
}
