package com.tedi.ecommerce.kafka.order;

/**
 * @author Tedi Kondakçiu
 */

public record Customer(
        String id,
        String firstName,
        String lastName,
        String email
) {
}
