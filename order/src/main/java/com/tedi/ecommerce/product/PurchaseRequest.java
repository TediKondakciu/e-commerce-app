package com.tedi.ecommerce.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;

/**
 * @author Tedi Kondakçiu
 */

@Validated
public record PurchaseRequest(
        @NotNull(message = "Product is mandatory!")
        Integer productId,

        @Positive(message = "Quantity should be positive!")
        double quantity
) {
}
