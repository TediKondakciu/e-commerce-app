package com.tedi.ecommerce.product;

import jakarta.validation.constraints.NotNull;

/**
 * @author Tedi Kondakçiu
 */

public record ProductPurchaseRequest(
        @NotNull(message = "You must select a product to purchase!")
        Integer productId,
        @NotNull(message = "Quantity is mandatory!")
        double quantity
) {
}
