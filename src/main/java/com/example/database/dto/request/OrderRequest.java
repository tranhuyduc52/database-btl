
package com.example.database.dto.request;

import java.sql.Date;
import java.util.List;

public record OrderRequest(
    Date order_time,
    String customerPhoneNumber,
    List<ProductInOrderRequest> producList   //Map<Id,quantity>
) {
    
}
