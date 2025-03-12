package com.example.database.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.database.model.Employee;

import jakarta.transaction.Transactional;

import java.util.Date;
import java.util.List;



public interface EmployeeRepo extends JpaRepository<Employee,Integer>{
    public Employee findByPhoneNumber(String phoneNumber);
    @Transactional
    @Modifying
    @Query("update Employee a set a.dob=:dob,a.address=:address,a.gender=:gender,a.name=:name where a.phoneNumber=:phoneNumber")
    public void updateEmployeeInfo(@Param("dob") Date dob,
                                    @Param("address") String address,
                                    @Param("gender") char gender,
                                    @Param("name") String name,
                                    @Param("phoneNumber") String phoneNumber
                                   );
    @Transactional
    @Modifying
    @Query("update Employee a set a.position=:position,a.unitSalary=:unitSalary where a.id=:id")
    public void updateEmployeeJob(@Param("position") String position,
                                  @Param("unitSalary") int unitSalary,
                                  @Param("id") int id);
}
