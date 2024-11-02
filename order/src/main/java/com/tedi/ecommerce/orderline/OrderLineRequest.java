package com.tedi.ecommerce.orderline;

/**
 * @author Tedi Kondakçiu
 */

public record OrderLineRequest(
        Integer id,
        Integer orderId,
        Integer productId,
        double quantity
) {
}
