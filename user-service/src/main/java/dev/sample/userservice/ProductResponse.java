package dev.sample.userservice;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;


@Data
@Builder
public class ProductResponse {
    private UUID id;
    private String productName;
    private String description;
    private double price;
}
