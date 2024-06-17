package com.chenjw.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/17 10:59
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerDemoController {

    @Value("${service-url.nacos-user-service}")
    private String service_url;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/example")
    public String example(){
        System.out.println(service_url + "/provider/example");
        return restTemplate.getForObject(service_url + "/provider/example", String.class);
    }

}
