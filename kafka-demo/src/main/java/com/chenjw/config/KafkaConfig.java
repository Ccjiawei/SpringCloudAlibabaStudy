package com.chenjw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

//@Configuration
public class KafkaConfig {


//    @Bean
//    public ProducerFactory<String, String> producerFactory() {
//        ProducerFactory<String, String> producerFactory = new ProducerFactory<>() {
//            @Override
//            public Producer createProducer() {
//                return new KafkaProducer();
//            }
//        };
//        return producerFactory;
//    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }
}
