package com.example.database.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.database.Order._order;

import jakarta.transaction.TransactionScoped;

import java.util.List;


public interface orderRepo extends JpaRepository<_order,Integer>{
    
}
