package com.example.database.Embedded;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class review_embed implements Serializable {
    private int customerId;
    private int productId;
}
