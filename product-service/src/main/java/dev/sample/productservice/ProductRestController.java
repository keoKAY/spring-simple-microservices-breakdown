package dev.sample.productservice;


import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
public class ProductRestController {

    @Value("${HOSTNAME:unknown}")
    private String hostname;

    @GetMapping("/slow")
    public ResponseEntity<String> slow()throws InterruptedException{
        //Thread.sleep(5000); // Delay for 5secs
        return ResponseEntity.ok("This is a delayed response ");
    }

    @GetMapping("/fail")
    public ResponseEntity<String>  fail(HttpServletRequest request){
        log.info("Retry attempted: method={}, path={}, from={}",
                request.getMethod(), request.getRequestURI(), request.getRemoteAddr());

        log.info("Retry attempted : {}", request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                .body("Simulated failure....!");
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
