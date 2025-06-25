package dev.sample.productservice.service;

import dev.sample.productservice.Product;
import dev.sample.productservice.ProductRepository;
import dev.sample.productservice.model.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    @Cacheable(value = "allProducts")
    public List<Product> getAllProducts(){
        simulateSlowService();
        return productRepository.findAll();
    }

    @CacheEvict(value = "allProducts", allEntries = true)
    public Product saveProduct(Product product)
    {
        return productRepository.save(product);
    }

    private void simulateSlowService(){
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e ){
            Thread.currentThread().interrupt();
        }
    }
}
