package com.tedi.ecommerce.customer;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Tedi Kondakçiu
 */

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
