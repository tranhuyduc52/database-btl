package com.example.database.service.interf;

import com.example.database.dto.request.ReviewRequest;
import com.example.database.model.ReviewEmbed;

public interface IReviewService {
    void createReview(ReviewRequest dto,String phoneNumber);
    void delReview(ReviewEmbed id);
}
