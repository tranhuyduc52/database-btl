package com.example.database.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.dto.request.ProductRequest;
import com.example.database.dto.request.ProductUpdateRequest;
import com.example.database.dto.respone.ProductResponse;
import com.example.database.dto.respone.ReviewResponse;
import com.example.database.mapper.ProductMapper;
import com.example.database.repository.ProductRepo;
import com.example.database.service.interf.IProductService;


@Service
public class ProductService implements IProductService{
    @Autowired
    private ProductRepo repo;
    @Autowired
    private ProductMapper mapper;
    public void addProduct(ProductRequest dto){
        repo.save(mapper.tProduct(dto));
    }
    public List<ProductResponse> getAllProducts(){
        return repo.findByIsAvailable(true).stream()
        .map(mapper::toProductResponseDto)
        .collect(Collectors.toList());
    }
    public void hideProduct(int id){
        repo.hideProduct(id);
    }
    public void delProduct(int id){
        repo.deleteById(id);
    }
    public List<ReviewResponse> getReview(int productId){
        var product = repo.findById(productId).orElse(null);
        var reviewList = product.getReviews();
        List<ReviewResponse> res = new ArrayList<>();
        for(var i: reviewList){
            var reviewResponseDto = new ReviewResponse(i.getId(),i.getDate(), i.getScore(),i.getComment(),i.getCustomer().getName(),product.getName());
            res.add(reviewResponseDto);
        }
        return res;
    }
    public void updateProduct(ProductUpdateRequest dto){
        repo.updateProduct(dto.id(),dto.name(),dto.unit_price(),dto.discount());
    }
}
