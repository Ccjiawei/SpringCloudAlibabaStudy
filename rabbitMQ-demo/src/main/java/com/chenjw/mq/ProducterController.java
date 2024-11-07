package com.chenjw.mq;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Description: 消费者
 * @Author: Chenjw
 * @Date: 2024-11-07 15:18
 */
@Data
@AllArgsConstructor
@RestController
public class ProducterController {

    private final RabbitTemplate rabbitTemplate;

    @GetMapping("sendTestQueue")
    public String sendTestQueue() {
        MyMessage message = new MyMessage(2L, "测试消息", "测试消息内容", new Date());
        rabbitTemplate.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, message);
        return "send success";
    }

}
