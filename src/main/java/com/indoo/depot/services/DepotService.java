package com.indoo.depot.services;

import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepotService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "payment-success-topic", groupId = "depot-service-group")
    public void arrangeShipping(String orderData) {
        // Arrange shipping for the order
        String details = arrangeShippingForOrder(orderData);
        System.out.println("Arrange Shipping: "+orderData);
        // Publish the shipping arrangement event
        kafkaTemplate.send("shipping-arrange-topic", details);
    }

    public String arrangeShippingForOrder(String orderData){
        return "ARRANGE SHIPPING";
    }
}
