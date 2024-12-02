package com.example.database.Relationship;

import com.example.database.Embedded.has_embed;
import com.example.database.Order._order;
import com.example.database.Product.product;

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
public class has {
    @EmbeddedId
    private has_embed id;
    @ManyToOne
    @MapsId("_orderId")
    @JoinColumn(name = "_order_ID")
    private _order _order;
    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_ID")
    private product product;
    private int quantity;
    private int price;
}
