package dev.sample.productservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String TOPIC="product-events";

    public void sendMessage(String message){
        kafkaTemplate.send(TOPIC, message);
    }
}
