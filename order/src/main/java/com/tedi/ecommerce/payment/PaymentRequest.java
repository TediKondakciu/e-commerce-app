package com.tedi.ecommerce.payment;

import com.tedi.ecommerce.customer.CustomerResponse;
import com.tedi.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

/**
 * @author Tedi Kondakçiu
 */

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
