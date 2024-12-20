package com.example.database.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.Order.orderDto;
import com.example.database.Order.orderMapper;
import com.example.database.Order.orderResponseDto;
import com.example.database.Repository.orderRepo;

@Service
public class orderService {
    @Autowired
    private orderRepo repo;
    @Autowired
    private orderMapper orderMapper;
    @Autowired
    hasService hasService;

    public void createOrder(orderDto dto,String phoneNumber){
        var order = orderMapper.t_order(dto,phoneNumber);
        repo.save(order);
        hasService.createHas(dto,order.getId());
    }
    public List<orderResponseDto> getAllOrder(){
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
