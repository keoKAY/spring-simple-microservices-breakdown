package dev.sample.productservice;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductRestController {

    @Value("${HOSTNAME:unknown}")
    private String hostname;
    @GetMapping("/get-all")
    public ResponseEntity<?> getAllProducts(){
        var hashResponse = new HashMap<String, Object>();

        var products = new ArrayList<ProductResponse>();
            products.add(
                    new ProductResponse(UUID.randomUUID(),
                    "Product 1",
                    "Description 1", 45));
            hashResponse.put("products", products);
            hashResponse.put("status", "OK");
            hashResponse.put("handled_by", hostname);
        return ResponseEntity.ok(hashResponse);
    }
}
