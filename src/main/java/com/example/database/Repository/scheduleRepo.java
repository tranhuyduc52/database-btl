package com.example.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.database.model.Schedule;
import com.example.database.model.ScheduleEmbed;

public interface ScheduleRepo extends JpaRepository<Schedule,ScheduleEmbed>{
    
}
