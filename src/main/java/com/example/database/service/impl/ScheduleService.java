package com.example.database.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.dto.request.ScheduleRequest;
import com.example.database.dto.respone.ScheduleResponse;
import com.example.database.mapper.ScheduleMapper;
import com.example.database.model.ScheduleEmbed;
import com.example.database.repository.ScheduleRepo;
import com.example.database.service.interf.IScheduleService;


@Service
public class ScheduleService implements IScheduleService{
    @Autowired
    private ScheduleRepo repo;
    @Autowired 
    private ScheduleMapper scheduleMapper;
    public void createSchedule(ScheduleRequest dto){
        repo.save(scheduleMapper.tSchedule(dto));
    }
    public List<ScheduleResponse> getAllSchedule(){
        return repo.findAll().stream()
        .map(scheduleMapper::tScheduleResponseDto)
        .collect(Collectors.toList());
    }
    public void delSchedule(ScheduleEmbed id){
        repo.deleteById(id);
    }
}
