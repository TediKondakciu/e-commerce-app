package com.tedi.ecommerce.product;

import java.math.BigDecimal;

/**
 * @author Tedi Kondakçiu
 */

public record PurchaseResponse(
        Integer productId,
        String name,
        String description,
        double quantity,
        BigDecimal price
) {
}
