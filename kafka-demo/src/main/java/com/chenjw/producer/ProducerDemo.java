package com.chenjw.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;

@Component
public class ProducerDemo {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;


    @Scheduled(cron = "*/5 * * * * ?")
    public void kafkaSendTest(){
        final ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("testFirstTopic", "test-first111111");
        future.addCallback(o -> System.out.println("succ"), throwable -> System.out.println("failure"));
    }

}
