package com.tedi.ecommerce.product;

import com.tedi.ecommerce.exception.ProductPurchaseException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Tedi Kondakçiu
 */

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public Integer createProduct(ProductRequest request){
        var product = mapper.toProduct(request);
        return repository.save(product).getId();
    }

    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request) {
        var productIds = request.stream().map(ProductPurchaseRequest::productId).toList();  // List of IDs in the request list
        var sortedProducts = repository.findAllByIdInOrderById(productIds);  // Sorted list of Products based on the IDs in the list of IDs
        if(productIds.size() != sortedProducts.size()){
            throw new ProductPurchaseException("One or more products are not available!");
        }
        var sortedRequest = request.stream().sorted(Comparator.comparing(ProductPurchaseRequest::productId)).toList();  // Sorted request list based on each element's ID
        var purchasedProducts = new ArrayList<ProductPurchaseResponse>();
        for(int i = 0; i < sortedProducts.size(); i++){
            var product = sortedProducts.get(i);
            var productRequest = sortedRequest.get(i);
            if(product.getAvailableQuantity() < productRequest.quantity()){
                throw new ProductPurchaseException("Insufficient stock quantity for product with id: "+productRequest.productId()+" !");
            }
            var newAvailableQuantity = product.getAvailableQuantity() - productRequest.quantity();
            product.setAvailableQuantity(newAvailableQuantity);
            repository.save(product);  // Updating quantity of a Product after a purchase

            purchasedProducts.add(mapper.toProductPurchaseResponse(product, productRequest.quantity()));
        }
        return purchasedProducts;
    }

    public ProductResponse findById(Integer productId) {
        return repository.findById(productId).map(mapper::toProductResponse).orElseThrow(() -> new EntityNotFoundException("Product with id "+productId+" not found!"));
    }

    public List<ProductResponse> findAll() {
        return repository.findAll().stream().map(mapper::toProductResponse).collect(Collectors.toList());
    }
}
