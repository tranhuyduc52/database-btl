package com.example.database.Relationship;

import java.sql.Date;

import com.example.database.Embedded.review_embed;

public record reviewResponseDto(
    review_embed id,
    Date date,
    int score,
    String comment,
    String customerName,
    String productName
) {
    
}
