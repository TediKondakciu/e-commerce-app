package com.tedi.ecommerce.order;

import org.springframework.stereotype.Service;

/**
 * @author Tedi Kondakçiu
 */

@Service
public class OrderMapper {
    public Order toOrder(OrderRequest request) {
        return Order.builder()
                .id(request.id())
                .reference(request.reference())
                .totalAmount(request.totalAmount())
                .paymentMethod(request.paymentMethod())
                .customerId(request.customerId())
                .build();
    }

    public OrderResponse toOrderResponse(Order order) {
        return new OrderResponse(order.getId(), order.getReference(), order.getTotalAmount(), order.getPaymentMethod(), order.getCustomerId());
    }
}
