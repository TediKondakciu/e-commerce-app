package com.tedi.ecommerce.order;

import com.tedi.ecommerce.product.PurchaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Tedi Kondakçiu
 */

public record OrderRequest(
        Integer id,

        String reference,

        @Positive(message = "Amount should be positive!")
        BigDecimal totalAmount,

        @NotNull(message = "Payment method should be specified!")
        PaymentMethod paymentMethod,

        @NotNull(message = "Customer should be present!")
        @NotEmpty(message = "Customer should be present!")
        @NotBlank(message = "Customer should be present!")
        String customerId,

        @NotEmpty(message = "At least one product should be purchased!")
        List<PurchaseRequest> products
) {
}
