package com.example.database.Repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.database.Customer.customer;

import jakarta.transaction.Transactional;


public interface customerRepo extends JpaRepository<customer,Integer>{
    public customer findByUsername(String username);
    @Transactional
    public void deleteByUsername(String username);
    @Transactional
    @Modifying
    @Query("update customer a set a.dob=:dob,a.phoneNumber=:phoneNumber,a.address=:address,a.gender=:gender,a.name=:name,a.email=:email where a.username=:username")
    public void updateCustomerInfo(@Param("dob") LocalDate dob,
                                   @Param("phoneNumber") int phoneNumber,
                                   @Param("address") String address,
                                   @Param("gender") String gender,
                                   @Param("name") String name,
                                   @Param("email") String email,
                                   @Param("username") String username);
}