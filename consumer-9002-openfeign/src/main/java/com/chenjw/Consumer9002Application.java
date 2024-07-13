package com.chenjw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/17 17:40
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Consumer9002Application {
    public static void main(String[] args) {
        SpringApplication.run(Consumer9002Application.class, args);
    }
}
