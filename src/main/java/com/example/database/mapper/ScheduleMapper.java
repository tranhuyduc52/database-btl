package com.example.database.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.dto.request.ScheduleRequest;
import com.example.database.dto.respone.ScheduleResponse;
import com.example.database.model.Schedule;
import com.example.database.repository.EmployeeRepo;
import com.example.database.repository.ShiftRepo;

@Service
public class ScheduleMapper {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ShiftRepo shiftRepo;
    @Autowired
    private ShiftMapper shiftMapper;
    public Schedule tSchedule(ScheduleRequest dto){
        var schedule = new Schedule();
        schedule.getId().setDate(dto.date());
        employeeRepo.findById(dto.employeeId()).orElse(null).addSchedule(schedule);
        shiftRepo.findById(dto.shiftId()).orElse(null).addSchedule(schedule);
        return schedule;
    }
    public ScheduleResponse tScheduleResponseDto(Schedule schedule){
        return new ScheduleResponse(schedule.getId(),schedule.getId().getDate(),schedule.getEmployee().getName(),shiftMapper.tShiftResponseDto( schedule.getShift()));
    }
}
