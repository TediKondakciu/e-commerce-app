package com.tedi.ecommerce.notification;

import com.tedi.ecommerce.kafka.payment.PaymentConfirmation;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Tedi Kondakçiu
 */

public interface NotificationRepository extends MongoRepository<Notification, String> {
}
