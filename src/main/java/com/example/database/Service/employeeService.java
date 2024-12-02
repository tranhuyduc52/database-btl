package com.example.database.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.Employee.employee;
import com.example.database.Employee.employeeDto;
import com.example.database.Employee.employeeMapper;
import com.example.database.Employee.employeeResponseDto;
import com.example.database.Employee.employeeUpdateDto;
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
    public void updateEmployee(employeeUpdateDto dto,String username){
        repo.updateEmployeeInfo(dto.dob(),dto.phoneNumber(),dto.address(),dto.gender(),dto.name(),dto.email(),username);
    }
    public employeeUpdateDto getEmployeeInfo(String username){
        return employeeMapper.tEmployeeUpdateDto(repo.findByUsername(username));
    }
    public void updateEmployeeJob(String position, int unitSalary, int id){
        repo.updateEmployeeJob(position,unitSalary,id);
    }
    public void calculateSalary(int id,int month, int year){
        var employee = repo.findById(id).orElse(null);
        var list = employee.getSchedules();
        int totalSalary = 0;
        for(var i:list){
            if(i.getDate().getMonthValue()==month&&i.getDate().getYear()==year){
                totalSalary+=employee.getUnitSalary();
            }
        }
        employee.setTotalSalary(totalSalary);
    }
    
}
