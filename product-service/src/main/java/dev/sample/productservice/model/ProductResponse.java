package dev.sample.productservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private UUID id;
    private String productName;
    private String description;
    private double price;
}
