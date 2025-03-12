package com.example.database.mapper;

import org.springframework.stereotype.Service;

import com.example.database.dto.request.CustomerRequest;
import com.example.database.dto.request.CustomerUpdateRequest;
import com.example.database.dto.respone.CustomerResponse;
import com.example.database.model.Customer;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest dto){
        var customer = new Customer();
        customer.setPhoneNumber(dto.phoneNumber());
        customer.setPassword(dto.password());
        return customer;
    }
    public CustomerResponse toCustomerResponseDTO(Customer customer){
        var customerResponseDTO=new CustomerResponse(customer.getId(),customer.getName(), customer.getAddress(), customer.getPhoneNumber());
        return customerResponseDTO;
    }
    public CustomerUpdateRequest tCustomerUpdateDto(Customer customer){
        return new CustomerUpdateRequest(customer.getDob(),customer.getPhoneNumber(),customer.getAddress(),customer.getGender(),customer.getName());
    }
}
