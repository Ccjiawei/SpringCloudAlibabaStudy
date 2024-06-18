package com.chenjw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/18 16:43
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.chenjw.mapper")
public class SeataStock8202Application {
    public static void main(String[] args) {
        SpringApplication.run(SeataStock8202Application.class, args);
    }
}
