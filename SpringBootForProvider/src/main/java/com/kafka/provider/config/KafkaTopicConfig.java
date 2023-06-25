package com.kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import java.util.Map;
import java.util.HashMap;
@Configuration
public class KafkaTopicConfig {

//    crear topic
    @Bean
    public NewTopic generateTopic(){
        Map<String,String> config = new HashMap<>();
        config.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE); //delete (borra mensaje), compact (mantiene el mensaje más actual)
        config.put(TopicConfig.RETENTION_MS_CONFIG, "86400000"); // Tiempo de retención de mensajes, defecto -1
        config.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824"); // Tamaño máximo del segmento - defecto 1073741824 bytes - 1GB
        config.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000012"); // Tamaño máximo de cada mensaje - defecto 1000000 - 1 MB

        return TopicBuilder.name("prueba-topic")
                .configs(config)
                .build();
    }
}
