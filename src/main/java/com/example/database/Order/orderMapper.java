package com.example.database.Order;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.Customer.customerMapper;
import com.example.database.Employee.employeeMapper;
import com.example.database.Product.productInOrderResponseDto;
import com.example.database.Product.productMapper;
import com.example.database.Relationship.has;
import com.example.database.Repository.customerRepo;
import com.example.database.Repository.employeeRepo;
import com.example.database.Repository.hasRepo;
import com.example.database.Repository.productRepo;

@Service
public class orderMapper {
    @Autowired
    private customerRepo customerRepo;
    @Autowired
    private employeeRepo employeeRepo;
    @Autowired
    private productRepo productRepo;
    @Autowired
    private customerMapper customerMapper;
    @Autowired
    private productMapper productMapper;
    @Autowired
    private employeeMapper employeeMapper;
    @Autowired
    private hasRepo hasRepo;
    
    public _order t_order(orderDto dto,String phoneNumber){
        var order= new _order();
        customerRepo.findByPhoneNumber(dto.customerPhoneNumber()).addOrder(order);
        employeeRepo.findByPhoneNumber(phoneNumber).addOrder(order);
        order.setOrder_time(dto.order_time());
        var producList = dto.producList();
        float total_charge = 0;
        for(var i : producList){
            var has = new has();
            has.setQuantity(i.quantity());
            order.addHas(has);
            var product = productRepo.findById(i.productId()).orElse(null);
            product.addHas(has);
            float price = product.getUnit_price()*i.quantity()*(100-product.getDiscount())/100;
            has.setPrice(price);
            hasRepo.save(has);
            total_charge+=price;
        }
        order.setTotal_charge(total_charge);
        return order;
    }
    public orderResponseDto tOrderResponseDto(_order order){
        List<productInOrderResponseDto> productInOrderResponseDtoList = new ArrayList<>();
        var list = order.getHases();
        for(has i:list){
            var productInOrderResponseDto = new productInOrderResponseDto(productMapper.toProductResponseDto(i.getProduct()),i.getQuantity());
            productInOrderResponseDtoList.add(productInOrderResponseDto);
        }
        return new orderResponseDto(order.getId(),order.getTotal_charge(),order.getOrder_time(),order.getEmployee().getName(),order.getCustomer().getName(),productInOrderResponseDtoList);
    }
}
