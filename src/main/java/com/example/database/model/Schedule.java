package com.example.database.model;


import java.sql.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    @EmbeddedId
    private ScheduleEmbed id = new ScheduleEmbed();

    @ManyToOne
    @MapsId("employeeId")
    @JoinColumn(name = "employee_ID")
    private Employee employee;

    @ManyToOne
    @MapsId("shiftId")
    @JoinColumn(name = "shift_ID")
    private Shift shift;

}
