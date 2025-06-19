package dev.sample.productservice.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequest {
    private String productName;
    private String description;
    private double price;
}
