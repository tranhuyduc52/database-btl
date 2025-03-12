package com.example.database.mapper;

import org.springframework.stereotype.Service;

import com.example.database.dto.request.EmployeeRequest;
import com.example.database.dto.request.EmployeeUpdateRequest;
import com.example.database.dto.respone.EmployeeResponse;
import com.example.database.model.Employee;

@Service
public class EmployeeMapper {
    public Employee tEmployee(EmployeeRequest dto){
        var employee = new Employee();
        employee.setUnitSalary(dto.unitSalary());
        employee.setPosition(dto.position());
        employee.setPhoneNumber(dto.phoneNumber());
        employee.setPassword(dto.password());
        return employee;
    }
    public EmployeeResponse tEmployeeResponseDto(Employee employee){
        return new EmployeeResponse(employee.getId(),employee.getName(),employee.getPhoneNumber(),employee.getStartDate(),employee.getPosition(),employee.getTotalSalary());
    }
    public EmployeeUpdateRequest tEmployeeUpdateDto(Employee employee){
        return new EmployeeUpdateRequest(employee.getDob(),employee.getPhoneNumber(),employee.getAddress(),employee.getGender(),employee.getName());
    }
}
