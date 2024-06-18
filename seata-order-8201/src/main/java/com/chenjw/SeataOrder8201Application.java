package com.chenjw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/18 16:43
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.chenjw.mapper")
public class SeataOrder8201Application {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrder8201Application.class, args);
    }
}
