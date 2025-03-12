package com.example.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.database.model.Product;

import java.util.List;


public interface ProductRepo extends JpaRepository<Product,Integer>{
    List<Product> findByIsAvailable(boolean isAvailable);
    @Modifying
    @Transactional
    @Query("update Product a set a.isAvailable=false where a.id=:id")
    void hideProduct(@Param("id") int id);
    @Modifying
    @Transactional
    @Query("update Product a set a.name=:name,a.unit_price=:unit_price,a.discount=:discount where a.id=:id")
    void updateProduct(@Param("id") int id,
    @Param("name") String name,
    @Param("unit_price") float unit_price,
    @Param("discount") int discount);
}