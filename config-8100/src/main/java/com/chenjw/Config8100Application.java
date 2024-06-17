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
public class Config8100Application {
    public static void main(String[] args) {
        SpringApplication.run(Config8100Application.class, args);
    }
}