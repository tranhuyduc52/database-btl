package com.example.database.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.dto.request.ReviewRequest;
import com.example.database.mapper.ReviewMapper;
import com.example.database.model.ReviewEmbed;
import com.example.database.repository.CustomerRepo;
import com.example.database.repository.ReviewRepo;
import com.example.database.service.interf.IReviewService;


@Service
public class ReviewService implements IReviewService{
    @Autowired
    private ReviewRepo repo;
    @Autowired
    private ReviewMapper reviewMapper;
    @Autowired
    private CustomerRepo customerRepo;
    public void createReview(ReviewRequest dto,String phoneNumber){
        var review = reviewMapper.tReview(dto);
        customerRepo.findByPhoneNumber(phoneNumber).addReview(review);
        repo.save(review);
    }
    public void delReview(ReviewEmbed id){
        repo.deleteById(id);
    }
}
