package com.example.database.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.database.Branch.branch;
import com.example.database.Customer.customer;
import com.example.database.Employee.employee;
import com.example.database.Relationship.has;

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
@AllArgsConstructor
@NoArgsConstructor
public class _order {
    @Id
    @GeneratedValue
    private int id;
    private int total_charge;
    private String payment_method;
    private LocalDateTime order_time;
    private boolean state;
    @OneToMany(mappedBy = "_order")
    private List<has> hases = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "employee_ID")
    private employee employee; 
    @ManyToOne
    @JoinColumn(name = "branch_ID")
    private branch branch;
    @ManyToOne
    @JoinColumn(name = "customer_ID")
    private customer customer;
    public void addHas(has has){
        this.hases.add(has);
        has.set_order(this);
    }
}
