package com.tedi.ecommerce.payment;

import com.tedi.ecommerce.notification.NotificationProducer;
import com.tedi.ecommerce.notification.PaymentNotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Tedi Kondakçiu
 */

@Service
@RequiredArgsConstructor
public class PaymentService {

    public final PaymentRepository repository;
    private final PaymentMapper mapper;
    private final NotificationProducer notificationProducer;

    public Integer createPayment(PaymentRequest request) {
        var payment = repository.save(mapper.toPayment(request));

        notificationProducer.sendNotification(new PaymentNotificationRequest(request.amount(), request.paymentMethod(),
                request.orderReference(), request.customer().firstName(), request.customer().lastName(), request.customer().email()));

        return payment.getId();
    }
}
