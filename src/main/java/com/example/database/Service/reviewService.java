package com.example.database.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.Embedded.review_embed;
import com.example.database.Relationship.reviewDto;
import com.example.database.Relationship.reviewMapper;
import com.example.database.Repository.customerRepo;
import com.example.database.Repository.reviewRepo;

@Service
public class reviewService {
    @Autowired
    private reviewRepo repo;
    @Autowired
    private reviewMapper reviewMapper;
    @Autowired
    private customerRepo customerRepo;
    public void createReview(reviewDto dto,String username){
        var review = reviewMapper.tReview(dto);
        customerRepo.findByUsername(username).addReview(review);
        repo.save(review);
    }
    public void delReview(review_embed id){
        repo.deleteById(id);
    }
}
