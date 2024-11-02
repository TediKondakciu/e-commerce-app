package com.tedi.ecommerce.customer;

/**
 * @author Tedi Kondakçiu
 */

public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email,
        Address address
) {

}
