package com.example.database.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ReviewEmbed implements Serializable {
    private int customerId;
    private int productId;
}
