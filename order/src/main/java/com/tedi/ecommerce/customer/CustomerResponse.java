package com.tedi.ecommerce.customer;

/**
 * @author Tedi Kondakçiu
 */

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email
) {
}
