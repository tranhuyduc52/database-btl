package com.example.database.repository;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.database.model.Customer;

import java.util.List;



public interface CustomerRepo extends JpaRepository<Customer,Integer>{
    public Customer findByPhoneNumber(String phoneNumber);
    @Transactional
    public void deleteByPhoneNumber(String phoneNumber);
    @Transactional
    @Modifying
    @Query("update Customer a set a.dob=:dob,a.address=:address,a.gender=:gender,a.name=:name where a.phoneNumber=:phoneNumber")
    public void updateCustomerInfo(@Param("dob") Date dob,
    @Param("address") String address,
    @Param("gender") char gender,
    @Param("name") String name,
    @Param("phoneNumber") String phoneNumber
                                   );
}