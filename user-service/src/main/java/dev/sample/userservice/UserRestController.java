package dev.sample.userservice;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
public class UserRestController {
    @GetMapping("/get-all")
    public ResponseEntity<?> getAllUsers(){
        List<Product> response = new ArrayList<>(); 
        response.add(Product.builder()
                .productId(UUID.randomUUID())
                        .productName("Product 1")
                .productPrice(100)
                        .productDescription("This is the product desc ription of the product 1 ")
                .build());
        return ResponseEntity.ok(response);
    }
}