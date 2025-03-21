package com.example.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.database.model._order;

import jakarta.transaction.TransactionScoped;

import java.util.List;


public interface OrderRepo extends JpaRepository<_order,Integer>{
    @Query("SELECT o FROM _order o WHERE YEAR(o.order_time)=:year AND MONTH(o.order_time)=:month")
    List<_order> findByMonthAndYear(@Param("year") int year,@Param("month") int month);
}
