package com.tedi.ecommerce.kafka.order;

import java.math.BigDecimal;

/**
 * @author Tedi Kondakçiu
 */

public record Product(
    Integer productId,
    String name,
    String description,
    double quantity,
    BigDecimal price
) {
}
