package dev.sample.productservice;

import lombok.Data;

@Data
public class ProductRequest {
    private String productName;
    private String description ;
    private double price;
}
