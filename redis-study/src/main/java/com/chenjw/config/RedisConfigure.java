package com.chenjw.config;


/**
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/12 11:36
 */
//@Configuration
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
