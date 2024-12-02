package com.example.database.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.database.Branch.branch;
import com.example.database.Order._order;
import com.example.database.Relationship.schedule;

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
public class employee {
    @Id
    @GeneratedValue
    private int id;
    private LocalDate dob;
    private int phoneNumber;
    private String address;
    private String gender;
    private String name;
    private String email;
    private Date startDate;
    private String position;
    private int unitSalary;
    private int totalSalary;
    private String username;
    private String password;
    @OneToMany(mappedBy = "employee")
    private List<schedule> schedules = new ArrayList<>();
    @OneToMany(mappedBy = "employee")
    private List<_order> _orders = new ArrayList<>();
    @ManyToOne()
    @JoinColumn(name = "branch_ID")
    private branch branch;
    public void addOrder(_order order){
        this._orders.add(order);
        order.setEmployee(this);
    }
    public void addSchedule(schedule schedule){
        this.schedules.add(schedule);
        schedule.setEmployee(this);
    }
}
