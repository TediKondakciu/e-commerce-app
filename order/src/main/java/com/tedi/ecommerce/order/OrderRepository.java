package com.tedi.ecommerce.order;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tedi Kondakçiu
 */

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
