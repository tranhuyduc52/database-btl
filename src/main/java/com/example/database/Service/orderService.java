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

    public void createOrder(orderDto dto,int phoneNumber){
        repo.save(orderMapper.t_order(dto,phoneNumber));
    }
    public List<orderResponseDto> getAllOrder(){
        return repo.findByState(true).stream()
        .map(orderMapper::tOrderResponseDto)
        .collect(Collectors.toList());
    }
    public void delOrder(int id){
        repo.deleteById(id);
    }
    public void hideOrder(int id){
        repo.hideProduct(id);
    }
}
