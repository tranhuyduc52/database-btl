package com.example.database.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.database.dto.request.EmployeeUpdateRequest;
import com.example.database.dto.request.OrderRequest;
import com.example.database.dto.respone.ExchangeResponse;
import com.example.database.service.impl.EmployeeService;
import com.example.database.service.impl.ExchangeService;
import com.example.database.service.impl.OrderService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@PreAuthorize("hasRole('EMPLOYEE')")
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    OrderService orderService;
    @Autowired
    ExchangeService exchangeService;

    @PostMapping("/order/create")
    public void createOrder(@RequestBody OrderRequest dto,Principal principal) {
        //TODO: process POST request
        orderService.createOrder(dto,principal.getName());
    }
    @PatchMapping("/update/info")
    public void updateInfo(@RequestBody EmployeeUpdateRequest dto) {
        employeeService.updateEmployee(dto);
    }
    
    @GetMapping("/get/info")
    public EmployeeUpdateRequest getEmployeeInfo(Principal principal) {
        return employeeService.getEmployeeInfo(principal.getName());
    }
    @GetMapping("view/exchange")
    public List<ExchangeResponse> getAllExchange() {
        return exchangeService.getAllExchange();
    }
    
    
}
