package com.chenjw.consumer;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerDemo {

    @KafkaListener(topics = {"testFirstTopic"}, groupId = "123")
    public void receive(String message){
        System.out.println("接收到的消息："+message);
    }
}
