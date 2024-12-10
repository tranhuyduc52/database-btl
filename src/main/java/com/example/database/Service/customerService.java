package com.example.database.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.Customer.customerDTO;
import com.example.database.Customer.customerMapper;
import com.example.database.Customer.customerUpdateDto;
import com.example.database.Order.orderMapper;
import com.example.database.Order.orderResponseDto;
import com.example.database.Relationship.exchangeMapper;
import com.example.database.Relationship.exchangeResponseDto;
import com.example.database.Repository.customerRepo;

@Service
public class customerService {
    @Autowired
    private customerRepo repo;
    @Autowired
    private exchangeMapper exchangeMapper;
    @Autowired
    private orderMapper orderMapper;
    @Autowired
    private customerMapper customerMapper;
    public customerUpdateDto getInfo(String phoneNumber){
        return customerMapper.tCustomerUpdateDto( repo.findByPhoneNumber(phoneNumber));
    }
    public List<exchangeResponseDto> getExchange(String phoneNumber){
        return repo.findByPhoneNumber(phoneNumber)
        .getExchanges().stream().map(exchangeMapper::tExchangeResponseDto)
        .collect(Collectors.toList());
    }
    public List<orderResponseDto> getOrder(String phoneNumber){
        return repo.findByPhoneNumber(phoneNumber).get_orders()
        .stream().map(orderMapper::tOrderResponseDto).collect(Collectors.toList());
    }
    public void createCustomer(customerDTO dto){
        repo.save(customerMapper.toCustomer(dto));
    }
    public void delCustomerByUsername(String phoneNumber){
        repo.deleteByPhoneNumber(phoneNumber);
    }
    public void updateCustomerInfo(customerUpdateDto dto){
        repo.updateCustomerInfo(dto.dob(),dto.address(),dto.gender(),dto.name(),dto.phoneNumber());
    }
    public int getPoint(String phoneNumber){
        return repo.findByPhoneNumber(phoneNumber).getPoint();
    }
}
