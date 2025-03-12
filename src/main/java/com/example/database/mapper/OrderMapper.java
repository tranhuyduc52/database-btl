package com.example.database.mapper;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.model._order;
import com.example.database.dto.request.OrderRequest;
import com.example.database.dto.respone.OrderResponse;
import com.example.database.dto.respone.ProductInOrderResponse;
import com.example.database.model.Has;
import com.example.database.repository.CustomerRepo;
import com.example.database.repository.EmployeeRepo;
import com.example.database.repository.HasRepo;
import com.example.database.repository.OrderRepo;
import com.example.database.repository.ProductRepo;

@Service
public class OrderMapper {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private HasRepo hasRepo;
    @Autowired
    OrderRepo orderRepo;
    
    public _order t_order(OrderRequest dto,String phoneNumber){
        var order= new _order();
        // orderRepo.save(order);
        order.setOrder_time(dto.order_time());
        var producList = dto.producList();
        float total_charge = 0;
        for(var i : producList){
            var product = productRepo.findById(i.productId()).orElse(null);
            float price = product.getUnit_price()*i.quantity()*(100-product.getDiscount())/100;
            total_charge+=price;
        }
        order.setTotal_charge(total_charge);
        customerRepo.findByPhoneNumber(dto.customerPhoneNumber()).addOrder(order);
        employeeRepo.findByPhoneNumber(phoneNumber).addOrder(order);
        return order;
    }
    public OrderResponse tOrderResponseDto(_order order){
        List<ProductInOrderResponse> productInOrderResponseDtoList = new ArrayList<>();
        var list = order.getHases();
        for(Has i:list){
            var productInOrderResponseDto = new ProductInOrderResponse(i.getProduct().getName(), i.getQuantity());
            productInOrderResponseDtoList.add(productInOrderResponseDto);
        }
        String cusName = "";
        String empName="";
        if(order.getCustomer()==null){ cusName = "Not Found";}
        else cusName = order.getCustomer().getName();
        if(order.getEmployee()==null) empName = "Not Found";
        else empName = order.getEmployee().getName();
        return new OrderResponse(order.getId(),order.getTotal_charge(),order.getOrder_time(),empName,cusName,productInOrderResponseDtoList);
    }
}
