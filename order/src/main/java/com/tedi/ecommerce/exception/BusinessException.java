package com.tedi.ecommerce.exception;

/**
 * @author Tedi Kondakçiu
 */

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
