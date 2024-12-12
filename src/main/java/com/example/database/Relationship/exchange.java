package com.example.database.Relationship;


import java.sql.Date;

import com.example.database.Customer.customer;
import com.example.database.Gift.gift;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class exchange {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "customer_ID")
    private customer customer;
    @ManyToOne
    @JoinColumn(name = "gift_ID")
    private gift gift;
    private int quantity;
    private Date date;
}
