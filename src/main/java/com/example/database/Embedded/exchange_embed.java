package com.example.database.Embedded;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class exchange_embed implements Serializable{
    private int customerId;
    private int giftId;
    
}
