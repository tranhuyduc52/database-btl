package com.example.database.Relationship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.Repository.productRepo;

@Service
public class reviewMapper {
    @Autowired
    private productRepo productRepo;
    public review tReview(reviewDto dto){
        var review = new review();
        review.setDate(dto.date());
        review.setScore(dto.score());
        review.setComment(dto.comment());
        productRepo.findById(dto.productId()).orElse(null).addReview(review);
        productRepo.findById(dto.productId()).orElse(null).updateRating(dto.score());
        return review;
    }
    // public reviewResponseDto tReviewResponseDto(review review){
    //     return new reviewResponseDto(review.getId(), review.getDate(), review.getScore(), review.getComment());
    // }
}
