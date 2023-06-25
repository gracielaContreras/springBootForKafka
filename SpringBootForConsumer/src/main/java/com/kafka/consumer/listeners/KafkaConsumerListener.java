package com.kafka.consumer.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerListener {
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerListener.class);


    @KafkaListener(topics = "prueba-topic", groupId = "groupId")
    public void listener(String message){
        logger.info("Mensaje Recibido, el mensaje es: " + message);
    }
}
