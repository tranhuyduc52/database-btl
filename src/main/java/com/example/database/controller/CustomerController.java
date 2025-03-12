package com.example.database.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.database.service.impl.CustomerService;
import com.example.database.service.impl.ExchangeService;
import com.example.database.service.impl.ReviewService;
import com.example.database.dto.request.CustomerRequest;
import com.example.database.dto.request.CustomerUpdateRequest;
import com.example.database.dto.request.ExchangeRequest;
import com.example.database.dto.request.ReviewRequest;
import com.example.database.dto.respone.ExchangeResponse;
import com.example.database.dto.respone.OrderResponse;
import com.example.database.service.impl.ReviewService;

import java.security.Principal;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@PreAuthorize("hasRole('CUSTOMER')")
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    DataSource dataSource;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ExchangeService exchangeService;


    @DeleteMapping("/delete")
    public void delCustomer(Principal principal){
        customerService.delCustomerByUsername(principal.getName());
    }
    @PatchMapping("/updateInfo")
    public void updateCustomerInfo(Principal principal, @RequestBody CustomerUpdateRequest dto) {
            customerService.updateCustomerInfo(dto);
    }
    @GetMapping("/order/view")
    public List<OrderResponse> getMethodName(Principal principal) {
        return customerService.getOrder(principal.getName());
    }
    @PostMapping("/review/create")
    public void postWriteReview(@RequestBody ReviewRequest dto,Principal principal) {
        reviewService.createReview(dto,principal.getName());
        
    }
    @PostMapping("/gift/exchange")
    public void exchangeGift(@RequestBody ExchangeRequest dto,Principal principal) {
        exchangeService.createExchange(dto,principal.getName());
    }
    @GetMapping("/point")
    public int getPoint(Principal principal) {
        return customerService.getPoint(principal.getName());
    }
    @GetMapping("/info")
    public CustomerUpdateRequest getInfo(Principal principal) {
        return customerService.getInfo(principal.getName());
    }
    @GetMapping("/gift/exchange/history")
    public List<ExchangeResponse> getExchangeHistory(Principal principal) {
        return customerService.getExchange(principal.getName());
    }
    
}
