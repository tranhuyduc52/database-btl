package com.example.database.service.interf;

import java.util.List;

import com.example.database.dto.request.CustomerRequest;
import com.example.database.dto.request.CustomerUpdateRequest;
import com.example.database.dto.respone.ExchangeResponse;
import com.example.database.dto.respone.OrderResponse;

public interface ICustomerService {
    CustomerUpdateRequest getInfo(String phoneNumber);
    List<ExchangeResponse> getExchange(String phoneNumber);
    List<OrderResponse> getOrder(String phoneNumber);
    void createCustomer(CustomerRequest dto);
    void delCustomerByUsername(String phoneNumber);
    void updateCustomerInfo(CustomerUpdateRequest dto);
    int getPoint(String phoneNumber);
}
