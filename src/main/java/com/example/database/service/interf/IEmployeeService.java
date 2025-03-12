package com.example.database.service.interf;

import java.util.List;

import com.example.database.dto.request.EmployeeCalSalaryRequest;
import com.example.database.dto.request.EmployeeRequest;
import com.example.database.dto.request.EmployeeUpdateRequest;
import com.example.database.dto.request.EmployeeUpdateJobRequest;
import com.example.database.dto.respone.EmployeeResponse;

public interface IEmployeeService {
    List<EmployeeResponse> findAllEmployee();
    void addEmployee(EmployeeRequest dto);
    void delEmployee(int id);
    void updateEmployee(EmployeeUpdateRequest dto);
    EmployeeUpdateRequest getEmployeeInfo(String phoneNumber);
    void updateEmployeeJob(EmployeeUpdateJobRequest dto);
    void calculateSalary(EmployeeCalSalaryRequest dto);

}
