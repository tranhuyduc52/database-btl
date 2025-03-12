package com.example.database.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.dto.request.OrderRequest;
import com.example.database.dto.respone.OrderResponse;
import com.example.database.mapper.OrderMapper;
import com.example.database.repository.OrderRepo;
import com.example.database.service.interf.IOrderService;


@Service
public class OrderService implements IOrderService{
    @Autowired
    private OrderRepo repo;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    HasService hasService;

    public void createOrder(OrderRequest dto,String phoneNumber){
        var order = orderMapper.t_order(dto,phoneNumber);
        repo.save(order);
        hasService.createHas(dto,order.getId());
    }
    public List<OrderResponse> getAllOrder(){
        return repo.findAll().stream()
        .map(orderMapper::tOrderResponseDto)
        .collect(Collectors.toList());
    }
    public void delOrder(int id){
        repo.deleteById(id);
    }
    public float calIncomeEachMonth(int year, int month){
        var list = repo.findByMonthAndYear(year, month);
        float res = 0;
        for(var i:list){
            res+=i.getTotal_charge();
        }
        return res;
    }
}
