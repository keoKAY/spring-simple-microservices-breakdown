package dev.sample.productservice;


import dev.sample.productservice.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductRestController {
    private final ProductRepository productRepository;

    private final KafkaProducerService kafkaProducerService;
    @Value("${HOSTNAME:unknown}")
    private String hostname;

    @PostMapping("/create-new")
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest request){
        Product product = new Product();
        product.setProductName(request.getProductName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        return ResponseEntity.ok(productRepository.save(product));
    }
    @GetMapping("/get-all")
    public ResponseEntity<?> getAllProducts(){
        var hashResponse = new HashMap<String, Object>();

        var products = new ArrayList<Product>(productRepository.findAll().stream().toList());


            hashResponse.put("products", products);
            hashResponse.put("status", "OK");
            hashResponse.put("handled_by", hostname);
        return ResponseEntity.ok(hashResponse);
    }
}
