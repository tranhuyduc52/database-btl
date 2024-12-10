package com.example.database.Relationship;

import java.sql.Date;

public record reviewDto(
    Date date,
    int score,
    String comment,
    int productId
) {
    
}
