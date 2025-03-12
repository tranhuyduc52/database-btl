package com.example.database.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.dto.request.OrderRequest;
import com.example.database.model.Has;
import com.example.database.repository.HasRepo;
import com.example.database.repository.OrderRepo;
import com.example.database.repository.ProductRepo;
import com.example.database.service.interf.IHasService;

@Service
public class HasService implements IHasService{
    @Autowired
    HasRepo hasRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    OrderRepo orderRepo;

    public void createHas(OrderRequest dto,int orderId){
        var list = dto.producList();
        for(var i:list){
            var has = new Has();
            var product = productRepo.findById(i.productId()).orElse(null);
            product.addHas(has);
            orderRepo.findById(orderId).orElse(null).addHas(has);
            has.setQuantity(i.quantity());
            has.setPrice(product.getUnit_price()*i.quantity()*(100-product.getDiscount())/100);
            hasRepo.save(has);
        }
    }
}
