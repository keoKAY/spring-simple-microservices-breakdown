package dev.sample.userservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.sample.userservice.ProductResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "product-events", groupId = "my-group")
    public void consumeProductEvent(String message){


        log.info("📩 [UserService] Received product event: {}" , message);
        try{
            ObjectMapper mapper = new ObjectMapper();
            ProductResponse product = mapper.readValue(message, ProductResponse.class);
            log.info("Parsed Product name is : {}", product.getProductName());
        }catch(JsonProcessingException ex ){
            ex.printStackTrace();
        }
    }
}
