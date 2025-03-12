package com.example.database.model;

import java.sql.Date;
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
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    private Date dob;
    private String phoneNumber; //function as username
    private String address;
    private char gender;
    private String name;
    private int point;
    private String password;
    private Date customerSince;
    @OneToMany(mappedBy = "customer")
    private List<Review> reviews= new ArrayList<>();
    @OneToMany(mappedBy = "customer")
    private List<Exchange> exchanges;
    @OneToMany(mappedBy = "customer")
    private List<_order> _orders= new ArrayList<>();
    public void addOrder(_order order){
        this._orders.add(order);
        order.setCustomer(this);
    }
    public void addExchange(Exchange exchange){
        this.exchanges.add(exchange);
        exchange.setCustomer(this);
    }
    public void addReview(Review review){
        this.reviews.add(review);
        review.setCustomer(this);
    }
    public void updatePoint(int quantity,int point){
        this.point = this.point - point*quantity;
    }
}
