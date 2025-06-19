package dev.sample.userservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "product-events", groupId = "my-group")
    public void consumeProductEvent(String message){
        log.info("📩 [UserService] Received product event: {}" , message);
    }
}
