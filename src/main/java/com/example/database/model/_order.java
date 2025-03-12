package com.example.database.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    private float total_charge;
    private Date order_time;

    @OneToMany(mappedBy = "_order")
    private List<Has> hases = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "employee_ID")
    private Employee employee; 
    
    @ManyToOne
    @JoinColumn(name = "customer_ID")
    private Customer customer;
    public void addHas(Has has){
        this.hases.add(has);
        has.set_order(this);
    }
}
