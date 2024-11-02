package com.tedi.ecommerce.kafka.payment;

import java.math.BigDecimal;

/**
 * @author Tedi Kondakçiu
 */

public record PaymentConfirmation(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String orderReference,
        String customerFirstName,
        String customerLastName,
        String customerEmail
) {
}
