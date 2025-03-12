package com.example.database.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Has {
    @EmbeddedId
    private HasEmbed id = new HasEmbed();
    @ManyToOne
    @MapsId("_orderId")
    @JoinColumn(name = "_order_ID")
    private _order _order;
    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_ID")
    private Product product;
    private int quantity;
    private float price;
}
