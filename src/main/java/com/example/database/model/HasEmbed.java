package com.example.database.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class HasEmbed implements Serializable{
    private int _orderId;
    private int productId;
}
