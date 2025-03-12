package com.example.database.service.interf;

import com.example.database.dto.request.OrderRequest;

public interface IHasService {
    void createHas(OrderRequest dto,int orderId);
}
