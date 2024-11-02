package com.tedi.ecommerce.notification;

import com.tedi.ecommerce.payment.PaymentMethod;

import java.math.BigDecimal;

/**
 * @author Tedi Kondakçiu
 */

public record PaymentNotificationRequest(

        BigDecimal amount,
        PaymentMethod paymentMethod,
        String orderReference,
        String customerFirstName,
        String customerLastName,
        String customerEmail
) {
}
