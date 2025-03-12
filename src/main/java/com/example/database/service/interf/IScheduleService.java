package com.example.database.service.interf;

import java.util.List;

import com.example.database.dto.request.ScheduleRequest;
import com.example.database.dto.respone.ScheduleResponse;
import com.example.database.model.ScheduleEmbed;

public interface IScheduleService {
    void createSchedule(ScheduleRequest dto);
    List<ScheduleResponse> getAllSchedule();
    void delSchedule(ScheduleEmbed id);
}
