package com.example.database.service.interf;

import java.util.List;

import com.example.database.dto.request.OrderRequest;
import com.example.database.dto.respone.OrderResponse;

public interface IOrderService {
    void createOrder(OrderRequest dto,String phoneNumber);
    List<OrderResponse> getAllOrder();
    void delOrder(int id);
    float calIncomeEachMonth(int year, int month);
    
}
