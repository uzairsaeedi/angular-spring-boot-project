package com.xyz.demo.domain;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    String productName;
    String variantName;
    Double salePrice;
    Long quantity;
    Double subTotal;
    Double costPrice;
}
