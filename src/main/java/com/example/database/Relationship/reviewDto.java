package com.example.database.Relationship;

import java.time.LocalDateTime;

public record reviewDto(
    LocalDateTime date,
    float score,
    String comment,
    int productId
) {
    
}
