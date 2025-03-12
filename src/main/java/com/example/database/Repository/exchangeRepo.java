package com.example.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.database.model.Customer;
import com.example.database.model.Exchange;




public interface ExchangeRepo extends JpaRepository<Exchange,Integer>{
    List<Exchange> findByCustomer(Customer customer);
}
