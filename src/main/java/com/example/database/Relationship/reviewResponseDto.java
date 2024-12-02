package com.example.database.Relationship;

import java.time.LocalDateTime;

import com.example.database.Embedded.review_embed;

public record reviewResponseDto(
    review_embed id,
    LocalDateTime date,
    float score,
    String comment,
    String customerName,
    String productName
) {
    
}
