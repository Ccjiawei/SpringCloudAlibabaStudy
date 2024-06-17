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

    @RequestMapping("/demo1")
    public String demo1(){
        return restTemplate.getForObject(service_url + "/demo1", String.class);
    }
    @RequestMapping("/demo2")
    public String demo2(){
        return restTemplate.getForObject(service_url + "/demo2", String.class);
    }
    @RequestMapping("/demo3")
    public String demo3(){
        return restTemplate.getForObject(service_url + "/demo3", String.class);
    }
    @RequestMapping("/demo4")
    public String demo4(){
        return restTemplate.getForObject(service_url + "/demo4", String.class);
    }
    @RequestMapping("/demo5")
    public String demo5(){
        return restTemplate.getForObject(service_url + "/demo5", String.class);
    }
    @RequestMapping("/demo6")
    public String demo6(){
        return restTemplate.getForObject(service_url + "/demo6", String.class);
    }
    @RequestMapping("/demo7")
    public String demo7(){
        return restTemplate.getForObject(service_url + "/demo7", String.class);
    }
    @RequestMapping("/demo8")
    public String demo8(){
        return restTemplate.getForObject(service_url + "/demo8", String.class);
    }
}
