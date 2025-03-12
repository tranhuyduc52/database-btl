package com.example.database.dto.respone;

import java.sql.Date;

import com.example.database.model.ReviewEmbed;

public record ReviewResponse(
    ReviewEmbed id,
    Date date,
    int score,
    String comment,
    String customerName,
    String productName
) {
    
}
