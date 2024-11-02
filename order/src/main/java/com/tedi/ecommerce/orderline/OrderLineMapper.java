package com.tedi.ecommerce.orderline;

import com.tedi.ecommerce.order.Order;
import org.springframework.stereotype.Service;

/**
 * @author Tedi Kondakçiu
 */

@Service
public class OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequest orderLineRequest) {
        return OrderLine.builder()
                .id(orderLineRequest.id())
                .order(Order.builder().id(orderLineRequest.orderId()).build())
                .productId(orderLineRequest.productId())
                .quantity(orderLineRequest.quantity())
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        return new OrderLineResponse(orderLine.getId(), orderLine.getQuantity());
    }
}
