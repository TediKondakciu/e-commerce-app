package com.tedi.ecommerce.order;

import com.tedi.ecommerce.product.PurchaseRequest;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Tedi Kondakçiu
 */

public record OrderResponse(
        Integer id,
        String reference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        String customerId
) {
}
