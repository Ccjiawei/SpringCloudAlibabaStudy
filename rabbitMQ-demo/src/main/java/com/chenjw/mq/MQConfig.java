package com.chenjw.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Description: mqconfig
 * @Author: Chenjw
 * @Date: 2024-11-07 13:52
 */
@Configuration
@Slf4j
public class MQConfig {

    public static final String ROUTING_KEY = "queue.a";
    public static final String EXCHANGE = "direct-exchange";
    /**
     * 创建队列A
     * @return
     */
    @Bean
    public Queue routingKeyQueueA() {
        return new Queue(ROUTING_KEY);
//        return QueueBuilder.durable(ROUTING_KEY).build();
    }

    /**
     * 创建交换机
     * @return
     */
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE);
    }

    /**
     * 绑定交换机与队列
     * @return
     */
    @Bean
    public Binding binding() {
        return new Binding(ROUTING_KEY, Binding.DestinationType.QUEUE, "direct-exchange", ROUTING_KEY, null);
    }

    /**
     * 配置rabbitTemplate，在消息发送失败时将失败消息返回给生产者
     * 保证消息可靠性，不丢失
     * @param connectionFactory 连接工厂
     * @return rabbitTemplate
     */
    @Bean
    public RabbitTemplate rabbitTemplate(CachingConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);

        // 消息发送到交换机确认机制  1.消息到交换机确认机制
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            log.info("消息发送交换机{}:correlationData({}),ack({}),cause({})",ack ? "成功":"失败", correlationData, ack, cause);
            if(!ack){
                // 发送失败进行重试机制

            }
        });

        //开启消息确认机制
        rabbitTemplate.setMandatory(true);

        //消息发送失败返回到队列中, yml需要配置 publisher-returns: true   2.消息到队列失败机制
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            log.info("消息丢失:exchange({}),route({}),replyCode({}),replyText({}),message:{}", exchange, routingKey, replyCode, replyText, message);
            // 路由失败，进行重试机制

        });

        return rabbitTemplate;
    }


}
