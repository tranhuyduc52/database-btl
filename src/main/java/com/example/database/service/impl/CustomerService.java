package com.example.database.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.database.repository.CustomerRepo;
import com.example.database.service.interf.ICustomerService;
import com.example.database.dto.request.CustomerRequest;
import com.example.database.dto.request.CustomerUpdateRequest;
import com.example.database.dto.respone.ExchangeResponse;
import com.example.database.dto.respone.OrderResponse;
import com.example.database.mapper.CustomerMapper;
import com.example.database.mapper.ExchangeMapper;
import com.example.database.mapper.OrderMapper;


@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private CustomerRepo repo;
    @Autowired
    private ExchangeMapper exchangeMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    DataSource dataSource;

    public CustomerUpdateRequest getInfo(String phoneNumber){
        return customerMapper.tCustomerUpdateDto( repo.findByPhoneNumber(phoneNumber));
    }
    public List<ExchangeResponse> getExchange(String phoneNumber){
        return repo.findByPhoneNumber(phoneNumber)
        .getExchanges().stream().map(exchangeMapper::tExchangeResponseDto)
        .collect(Collectors.toList());
    }
    public List<OrderResponse> getOrder(String phoneNumber){
        return repo.findByPhoneNumber(phoneNumber).get_orders()
        .stream().map(orderMapper::tOrderResponseDto).collect(Collectors.toList());
    }
    public void createCustomer(CustomerRequest dto){
        repo.save(customerMapper.toCustomer(dto));
    }
    @Transactional
    public void delCustomerByUsername(String phoneNumber){
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
        manager.deleteUser(phoneNumber);
        repo.deleteByPhoneNumber(phoneNumber);
    }
    public void updateCustomerInfo(CustomerUpdateRequest dto){
        repo.updateCustomerInfo(dto.dob(),dto.address(),dto.gender(),dto.name(),dto.phoneNumber());
    }
    public int getPoint(String phoneNumber){
        return repo.findByPhoneNumber(phoneNumber).getPoint();
    }
}
