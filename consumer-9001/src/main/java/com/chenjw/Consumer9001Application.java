package com.chenjw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description
 * @Author: Chenjiawei
 * @Date: ${DATE} ${TIME}
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Consumer9001Application {
    public static void main(String[] args) {
        SpringApplication.run(Consumer9001Application.class, args);
    }
}