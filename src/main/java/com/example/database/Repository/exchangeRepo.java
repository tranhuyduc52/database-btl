package com.example.database.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.database.Relationship.exchange;
import com.example.database.Customer.customer;


public interface exchangeRepo extends JpaRepository<exchange,Integer>{
    List<exchange> findByCustomer(customer customer);
}
