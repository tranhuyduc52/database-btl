package com.example.database.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.database.Product.product;

import jakarta.transaction.TransactionScoped;

import java.util.List;


public interface productRepo extends JpaRepository<product,Integer>{
    List<product> findByIsAvailable(boolean isAvailable);
    @Modifying
    @TransactionScoped
    @Query("update product a set a.isAvailable=false where a.id=:id")
    void hideProduct(@Param("id") int id);
    @Modifying
    @TransactionScoped
    @Query("update product a set a.name=:name,a.unit_price=:unit_price,a.discount=:discount where a.id=:id")
    void updateProduct(@Param("id") int id,
    @Param("name") String name,
    @Param("unit_price") float unit_price,
    @Param("discount") int discount);
}