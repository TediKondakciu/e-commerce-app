package com.tedi.ecommerce.handler;

import java.util.Map;

/**
 * @author  Tedi Kondakçiu
 */

public record ErrorResponse(Map<String, String> errors) {
}
