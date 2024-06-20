package com.chenjw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/20 16:58
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.chenjw.mapper")
public class NbaTeam8004Application {
    public static void main(String[] args) {
        SpringApplication.run(NbaTeam8004Application.class, args);
    }
}
