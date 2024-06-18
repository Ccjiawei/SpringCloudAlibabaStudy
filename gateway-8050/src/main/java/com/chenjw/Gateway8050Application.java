package com.chenjw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/18 14:47
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Gateway8050Application {
    public static void main(String[] args) {
        SpringApplication.run(Gateway8050Application.class, args);
    }
}
