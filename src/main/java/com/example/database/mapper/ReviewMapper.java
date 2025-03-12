package com.example.database.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.dto.request.ReviewRequest;
import com.example.database.model.Review;
import com.example.database.repository.ProductRepo;

@Service
public class ReviewMapper {
    @Autowired
    private ProductRepo productRepo;
    public Review tReview(ReviewRequest dto){
        var review = new Review();
        review.setDate(dto.date());
        review.setScore(dto.score());
        review.setComment(dto.comment());
        var product = productRepo.findById(dto.productId()).orElse(null);
        product.addReview(review);
        // product.updateRating(dto.score());
        // productRepo.save(product);
        return review;
    }
    // public reviewResponseDto tReviewResponseDto(review review){
    //     return new reviewResponseDto(review.getId(), review.getDate(), review.getScore(), review.getComment());
    // }
}
