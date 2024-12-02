package com.example.database.Embedded;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class has_embed implements Serializable{
    private int _orderId;
    private int productId;
}
