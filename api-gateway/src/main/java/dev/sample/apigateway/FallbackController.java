package dev.sample.apigateway;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
    @RequestMapping("/fallback/products")
    public ResponseEntity<String> productFallback(){
        return ResponseEntity.ok("Product Service is currently unavailable. Please try again later. ");
    }

    @RequestMapping("/fallback/users")
    public ResponseEntity<String> userFallback(){
        return ResponseEntity.ok("User Service is currently unavailable. Please try again later ");
    }
}
