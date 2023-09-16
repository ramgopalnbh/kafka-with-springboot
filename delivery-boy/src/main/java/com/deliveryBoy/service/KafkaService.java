package com.deliveryBoy.service;

import com.deliveryBoy.config.AppConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    public boolean updateLocation(String location){
        log.info("-----Inside Kafka Service-----");
        this.kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME, location);
        log.info("-----Inside Kafka Service with location: "+location);
        return true;
    }
}
