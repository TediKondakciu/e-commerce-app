package com.tedi.ecommerce.kafka;

import com.tedi.ecommerce.customer.CustomerResponse;
import com.tedi.ecommerce.order.PaymentMethod;
import com.tedi.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Tedi Kondakçiu
 */

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
