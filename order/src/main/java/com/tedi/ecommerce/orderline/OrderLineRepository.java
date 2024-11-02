package com.tedi.ecommerce.orderline;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Tedi Kondakçiu
 */

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
    List<OrderLine> findAllByOrderId(Integer orderId);
}
