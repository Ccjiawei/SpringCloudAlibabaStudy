package com.chenjw.mq;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Description: 消费者
 * @Author: Chenjw
 * @Date: 2024-11-07 15:23
 */
@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = MQConfig.ROUTING_KEY)
    public void receive(MyMessage messageInfo, Message message, Channel channel) {
        try {
            log.info("receive message: {}", messageInfo);
            if (messageInfo.getId() % 2 == 0) {
                // 模拟消费失败，消息会重新回到队列
                throw new RuntimeException("消费失败");
            }
            // 手动确认消息，参数说明：tag，是否批量
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            log.error("receive message error: {}", e.getMessage());
            try {
                channel.basicRecover();
            } catch (IOException ex) {
                log.error("basicRecover error: {}", ex.getMessage());
            }
        }
    }

}
