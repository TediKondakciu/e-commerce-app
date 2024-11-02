package com.tedi.ecommerce.customer;

import lombok.*;
import org.springframework.validation.annotation.Validated;

/**
 * @author Tedi Kondakçiu
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Validated
public class Address {
    private String street;
    private String houseNumber;
    private String zipCode;
}
