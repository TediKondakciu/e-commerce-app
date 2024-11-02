package com.tedi.ecommerce.payment;

import org.springframework.stereotype.Service;

/**
 * @author Tedi Kondakçiu
 */

@Service
public class PaymentMapper {
    public Payment toPayment(PaymentRequest request) {
        return Payment.builder()
                .id(request.id())
                .amount(request.amount())
                .paymentMethod(request.paymentMethod())
                .orderId(request.orderId())
                .build();
    }
}
