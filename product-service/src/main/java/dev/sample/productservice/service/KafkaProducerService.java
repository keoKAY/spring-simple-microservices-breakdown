package dev.sample.productservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.sample.productservice.Product;
import dev.sample.productservice.model.ProductResponse;
import dev.sample.productservice.model.event.ProductEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;




@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String TOPIC="product-events";

    public void sendMessage(String message){
        kafkaTemplate.send(TOPIC, message);
    }

    public void sendProductCreatedEvent(Product product){
        ObjectMapper mapper = new ObjectMapper();
        try {

            ProductEvent<Product> productEvent = ProductEvent.<Product>builder()
                    .data(product)
                    .eventName("New Product is created ! ")
                    .build();
            String message = mapper.writeValueAsString(productEvent);
            kafkaTemplate.send(TOPIC, message);

        } catch (JsonProcessingException e) {
            // should handle this better inside the rest controller advisor
            log.info("Something is wrong with kafka event: {}",e.getMessage());
            e.printStackTrace();
        }
    }


}
