package com.example.database.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shift{
    @Id
    @GeneratedValue
    private int id;
    private String startTime;
    private String endTime;
    private float hour;
    @OneToMany(mappedBy = "shift")
    private List<Schedule> schedules = new ArrayList<>();
    public void addSchedule(Schedule schedule){
        schedules.add(schedule);
        schedule.setShift(this);
    }
}
