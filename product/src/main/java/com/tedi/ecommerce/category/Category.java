package com.tedi.ecommerce.category;

import com.tedi.ecommerce.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * @author Tedi Kondakçiu
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Category {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Product> productList;
}
