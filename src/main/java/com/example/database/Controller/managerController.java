package com.example.database.controller;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.database.dto.request.EmployeeCalSalaryRequest;
import com.example.database.dto.request.EmployeeRequest;
import com.example.database.dto.request.EmployeeUpdateJobRequest;
import com.example.database.dto.request.GiftRequest;
import com.example.database.dto.request.ProductRequest;
import com.example.database.dto.request.ProductUpdateRequest;
import com.example.database.dto.request.ScheduleRequest;
import com.example.database.dto.request.ShiftRequest;
import com.example.database.dto.respone.EmployeeResponse;
import com.example.database.dto.respone.ExchangeResponse;
import com.example.database.dto.respone.GiftResponse;
import com.example.database.dto.respone.OrderResponse;
import com.example.database.dto.respone.ScheduleResponse;
import com.example.database.service.impl.EmployeeService;
import com.example.database.service.impl.ExchangeService;
import com.example.database.service.impl.GiftService;
import com.example.database.service.impl.OrderService;
import com.example.database.service.impl.ProductService;
import com.example.database.service.impl.ScheduleService;
import com.example.database.service.impl.ShiftService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/manager")
@PreAuthorize("hasRole('MANAGER')")
public class ManagerController {
    @Autowired
    DataSource dataSource;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    ShiftService shiftService;
    @Autowired
    ProductService productService;
    @Autowired
    GiftService giftService;
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    OrderService orderService;
    @Autowired
    ExchangeService exchangeService;

    @PostMapping("create/employee")
    public String createEmployee(@RequestBody EmployeeRequest dto) 
    {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
        if(manager.userExists(dto.phoneNumber())){return "Username already exists";}

        UserDetails user = User.withUsername(dto.phoneNumber())
        .password(passwordEncoder.encode(dto.password()))
        .roles("EMPLOYEE")
        .build();
        manager.createUser(user);
        employeeService.addEmployee(dto);
        return "Employee is created successfully!";
    }
    @PostMapping("/create/shift")
    public void createShift(@RequestBody ShiftRequest dto) {
        shiftService.createShift(dto);
    }
    @PostMapping("/create/product")
    public void createProduct(@RequestBody ProductRequest dto) {
        productService.addProduct(dto);
    }
    @PostMapping("/create/gift")
    public void createGift(@RequestBody GiftRequest dto) {
        giftService.addGift(dto);
    }
    @GetMapping("/view/employees")
    public List<EmployeeResponse> getAllEmployees() {
        return employeeService.findAllEmployee();
    }
    @PostMapping("/create/schedule")
    public void createSchedule(@RequestBody ScheduleRequest dto) {
        //TODO: process POST request
        scheduleService.createSchedule(dto);
    }
    @GetMapping("/view/schedule")
    public List<ScheduleResponse> getAllSchedule() {
        return scheduleService.getAllSchedule();
    }
    @PatchMapping("/update/employee/salary")
    public void putMethodName(@RequestBody EmployeeCalSalaryRequest dto) {
        //TODO: process PUT request
        employeeService.calculateSalary(dto);
    }
    @PatchMapping("/update/employee/job")
    public void updateEmployeeJob(@RequestBody EmployeeUpdateJobRequest dto) {
        //TODO: process PUT request
        employeeService.updateEmployeeJob(dto);
    }
    @DeleteMapping("/delete/employee")
    public void delEmployee(@RequestParam int id){
         employeeService.delEmployee(id);
    }
    @GetMapping("/view/orders")
    public List<OrderResponse> getOrders() {
        return orderService.getAllOrder();
    }
    
    @PatchMapping("/delete/gift")
    public void delGift(@RequestParam int id) {
        //TODO: process PUT request
        giftService.hideGift(id);
    }
    @PatchMapping("/delete/product")
    public void delProduct( @RequestParam int id) {
        //TODO: process PUT request
        productService.hideProduct(id);
    }
    @PatchMapping("/update/product")
    public void updateProduct(@RequestBody ProductUpdateRequest dto) {
        //TODO: process PUT request
        productService.updateProduct(dto);
    }
    @PatchMapping("/update/gift")
    public void updateGift(@RequestBody GiftResponse dto) {
        //TODO: process PUT request
        giftService.updateGift(dto);
    }
    @GetMapping("/view/exchange")
    public List<ExchangeResponse> getAllExchange() {
        return exchangeService.getAllExchange();
    }
    @GetMapping("/income")
    public float incomeEachMonth(@RequestParam int year,@RequestParam int month) {
        return orderService.calIncomeEachMonth(year, month);
    }
    
}
