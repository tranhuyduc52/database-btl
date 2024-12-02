package com.example.database.Repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.database.Employee.employee;

import jakarta.transaction.Transactional;
import java.util.List;



public interface employeeRepo extends JpaRepository<employee,Integer>{
    employee findByUsername(String username);
    @Transactional
    @Modifying
    @Query("update employee a set a.dob=:dob,a.phoneNumber=:phoneNumber,a.address=:address,a.gender=:gender,a.name=:name,a.email=:email where a.username=:username")
    public void updateEmployeeInfo(@Param("dob") LocalDate dob,
                                   @Param("phoneNumber") int phoneNumber,
                                   @Param("address") String address,
                                   @Param("gender") String gender,
                                   @Param("name") String name,
                                   @Param("email") String email,
                                   @Param("username") String username);
    @Transactional
    @Modifying
    @Query("update employee a set a.position=:position,a.unitSalary=:unitSalary where a.id=:id")
    public void updateEmployeeJob(@Param("position") String position,
                                  @Param("unitSalary") int unitSalary,
                                  @Param("id") int id);
}
