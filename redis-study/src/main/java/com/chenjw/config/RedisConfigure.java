package com.chenjw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.List;

/**
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/12 11:36
 */
@Configuration
public class RedisConfigure {


    /*@Bean
    public RedisTemplate<String, List<?>> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, List<?>> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(List.class));
        return redisTemplate;
    }*/
}
