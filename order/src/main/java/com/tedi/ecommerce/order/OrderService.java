package com.tedi.ecommerce.order;

import com.tedi.ecommerce.customer.CustomerClient;
import com.tedi.ecommerce.exception.BusinessException;
import com.tedi.ecommerce.kafka.OrderConfirmation;
import com.tedi.ecommerce.kafka.OrderProducer;
import com.tedi.ecommerce.orderline.OrderLineRequest;
import com.tedi.ecommerce.orderline.OrderLineService;
import com.tedi.ecommerce.payment.PaymentClient;
import com.tedi.ecommerce.payment.PaymentRequest;
import com.tedi.ecommerce.product.ProductClient;
import com.tedi.ecommerce.product.PurchaseRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author Tedi Kondakçiu
 */

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final CustomerClient customerClient;
    private final PaymentClient paymentClient;
    private final ProductClient productClient;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;

    public Integer createOrder(OrderRequest request) {
        // Check if the customer exists
        var customer = customerClient.findCustomerById(request.customerId()).orElseThrow(() -> new BusinessException("Cannot create order: No customer present with id: "+request.customerId()+" !"));

        // Purchase the products
        var purchasedProducts = productClient.purchaseProducts(request.products());

        // Save order
        var order = repository.save(mapper.toOrder(request));

        // Save order lines
        for(PurchaseRequest purchaseRequest: request.products()){
            orderLineService.saveOrderLine(new OrderLineRequest(null, order.getId(), purchaseRequest.productId(), purchaseRequest.quantity()));
        }

        // Start payment process
        paymentClient.createPayment(new PaymentRequest(request.totalAmount(), request.paymentMethod(), order.getId(), order.getReference(), customer));

        // Send order confirmation to notification-ms through Kafka
        orderProducer.sendOrderConfirmation(new OrderConfirmation(request.reference(), request.totalAmount(), request.paymentMethod(), customer, purchasedProducts));

        return order.getId();
    }

    public List<OrderResponse> findAll() {
        return repository.findAll().stream().map(mapper::toOrderResponse).collect(Collectors.toList());
    }

    public OrderResponse findById(Integer orderId) {
        return repository.findById(orderId).map(mapper::toOrderResponse).orElseThrow(() -> new EntityNotFoundException("No order found with the provided id: " + orderId));
    }
}
