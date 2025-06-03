package dev.sample.userservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private UUID productId;
    private String productName;
    private double productPrice;
    private String productDescription;
}
