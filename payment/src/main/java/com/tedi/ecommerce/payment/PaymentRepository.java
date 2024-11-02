package com.tedi.ecommerce.payment;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tedi Kondakçiu
 */

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
