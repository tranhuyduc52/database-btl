package com.example.database.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private Date dob;
    private String phoneNumber;
    private String address;
    private char gender;
    private String name;
    private Date startDate;
    private String position;   //create enum: manager, cashier, barista, waiter
    private int unitSalary;
    private int totalSalary;
    private String password;
    @OneToMany(mappedBy = "employee")
    private List<Schedule> schedules = new ArrayList<>();
    @OneToMany(mappedBy = "employee")
    private List<_order> _orders = new ArrayList<>();
    
    public void addOrder(_order order){
        this._orders.add(order);
        order.setEmployee(this);
    }
    public void addSchedule(Schedule schedule){
        this.schedules.add(schedule);
        schedule.setEmployee(this);
    }
}
