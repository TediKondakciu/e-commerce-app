package com.tedi.ecommerce.payment;

import java.math.BigDecimal;

/**
 * @author Tedi Kondakçiu
 */

public record PaymentRequest(
        Integer id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        Customer customer
) {
}
