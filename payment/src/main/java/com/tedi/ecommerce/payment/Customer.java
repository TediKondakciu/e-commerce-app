package com.tedi.ecommerce.payment;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

/**
 * @author Tedi Kondakçiu
 */

@Validated
public record Customer(
        String id,

        @NotNull(message = "Firstname is required!")
        String firstName,

        @NotNull(message = "Lastname is required!")
        String lastName,

        @NotNull(message = "Email is required!")
        @Email(message = "Email address is not valid!")
        String email
) {
}
