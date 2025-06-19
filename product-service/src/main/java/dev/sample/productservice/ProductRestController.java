package dev.sample.productservice;


import dev.sample.productservice.model.ProductRequest;
import dev.sample.productservice.model.ProductResponse;
import dev.sample.productservice.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductRestController {

    private final KafkaProducerService kafkaProducerService;
    @Value("${HOSTNAME:unknown}")
    private String hostname;



    @PostMapping("/create-new")
    //@RequestBody ProductRequest request
    public ResponseEntity<String>createProduct(){
        kafkaProducerService.sendMessage("New product has created! ");
        return ResponseEntity.ok("Created a new product! ");
    }
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
