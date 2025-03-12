package com.example.database.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.database.model.Employee;
import com.example.database.repository.EmployeeRepo;
import com.example.database.service.interf.IEmployeeService;
import com.example.database.dto.request.EmployeeCalSalaryRequest;
import com.example.database.dto.request.EmployeeRequest;
import com.example.database.dto.request.EmployeeUpdateRequest;
import com.example.database.dto.request.EmployeeUpdateJobRequest;
import com.example.database.dto.respone.EmployeeResponse;
import com.example.database.mapper.EmployeeMapper;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    private EmployeeRepo repo;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    DataSource dataSource;

    public List<EmployeeResponse> findAllEmployee(){
        return repo.findAll().stream()
        .map(employeeMapper::tEmployeeResponseDto)
        .collect(Collectors.toList());
    }
    public void addEmployee(EmployeeRequest dto){
        repo.save(employeeMapper.tEmployee(dto));
    }
    @Transactional
    public void delEmployee(int id){
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
        manager.deleteUser(repo.findById(id).orElse(null).getPhoneNumber());
        repo.deleteById(id);
    }
    public void updateEmployee(EmployeeUpdateRequest dto){
        repo.updateEmployeeInfo(dto.dob(),dto.address(),dto.gender(),dto.name(),dto.phoneNumber());
    }
    public EmployeeUpdateRequest getEmployeeInfo(String phoneNumber){
        return employeeMapper.tEmployeeUpdateDto(repo.findByPhoneNumber(phoneNumber));
    }
    public void updateEmployeeJob(EmployeeUpdateJobRequest dto){
        repo.updateEmployeeJob(dto.position(),dto.unitSalary(),dto.id());
    }
    public void calculateSalary(EmployeeCalSalaryRequest dto){
        var employee = repo.findById(dto.id()).orElse(null);
        var list = employee.getSchedules();
        int totalSalary = 0;
        for(var i:list){
            if(i.getId().getDate().toLocalDate().getMonthValue()==dto.month()&&i.getId().getDate().toLocalDate().getYear()==dto.year()){
                totalSalary+=employee.getUnitSalary()*i.getShift().getHour();
            }
        }
        employee.setTotalSalary(totalSalary);
        repo.save(employee);
    }
    
}
