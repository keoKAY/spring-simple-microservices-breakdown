package dev.sample.productservice;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductRestController {

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllProducts(){
        var products = new ArrayList<ProductResponse>();
        products.add(new ProductResponse(UUID.randomUUID(), "Product 1", "Description 1", 45));
        return ResponseEntity.ok(products);
    }
}
