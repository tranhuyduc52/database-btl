package com.example.database.service.interf;

import java.util.List;

import com.example.database.dto.request.ProductRequest;
import com.example.database.dto.request.ProductUpdateRequest;
import com.example.database.dto.respone.ProductResponse;
import com.example.database.dto.respone.ReviewResponse;

public interface IProductService {
    void addProduct(ProductRequest dto);
    List<ProductResponse> getAllProducts();
    void hideProduct(int id);
    void delProduct(int id);
    List<ReviewResponse> getReview(int productId);
    void updateProduct(ProductUpdateRequest dto);
}
