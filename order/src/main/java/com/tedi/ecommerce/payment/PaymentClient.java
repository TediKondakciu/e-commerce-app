package com.tedi.ecommerce.payment;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Tedi Kondakçiu
 */

@FeignClient(name = "payment-service", url = "${application.config.payment-url}")
public interface PaymentClient {

    @PostMapping
    Integer createPayment(@RequestBody PaymentRequest request);
}
