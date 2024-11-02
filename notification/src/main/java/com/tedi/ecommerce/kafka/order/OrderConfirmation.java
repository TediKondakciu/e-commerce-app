package com.tedi.ecommerce.kafka.order;

import com.tedi.ecommerce.kafka.payment.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Tedi Kondakçiu
 */

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        Customer customer,
        List<Product> products
) {
}
