package com.example.database.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.Employee.employee;
import com.example.database.Employee.employeeCalSalaryDto;
import com.example.database.Employee.employeeDto;
import com.example.database.Employee.employeeMapper;
import com.example.database.Employee.employeeResponseDto;
import com.example.database.Employee.employeeUpdateDto;
import com.example.database.Employee.employeeUpdateJobDto;
import com.example.database.Repository.employeeRepo;

@Service
public class employeeService {
    @Autowired
    private employeeRepo repo;
    @Autowired
    private employeeMapper employeeMapper;
    public List<employeeResponseDto> findAllEmployee(){
        return repo.findAll().stream()
        .map(employeeMapper::tEmployeeResponseDto)
        .collect(Collectors.toList());
    }
    public void addEmployee(employeeDto dto){
        repo.save(employeeMapper.tEmployee(dto));
    }
    public void delEmployee(int id){
        repo.deleteById(id);
    }
    public void updateEmployee(employeeUpdateDto dto){
        repo.updateEmployeeInfo(dto.dob(),dto.address(),dto.gender(),dto.name(),dto.phoneNumber());
    }
    public employeeUpdateDto getEmployeeInfo(String phoneNumber){
        return employeeMapper.tEmployeeUpdateDto(repo.findByPhoneNumber(phoneNumber));
    }
    public void updateEmployeeJob(employeeUpdateJobDto dto){
        repo.updateEmployeeJob(dto.position(),dto.unitSalary(),dto.id());
    }
    public void calculateSalary(employeeCalSalaryDto dto){
        var employee = repo.findById(dto.id()).orElse(null);
        var list = employee.getSchedules();
        int totalSalary = 0;
        for(var i:list){
            if(i.getDate().toLocalDate().getMonthValue()==dto.month()&&i.getDate().toLocalDate().getYear()==dto.year()){
                totalSalary+=employee.getUnitSalary();
            }
        }
        employee.setTotalSalary(totalSalary);
    }
    
}
