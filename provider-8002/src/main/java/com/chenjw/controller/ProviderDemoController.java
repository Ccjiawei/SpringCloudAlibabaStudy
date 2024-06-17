package com.chenjw.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/17 10:51
 */
@RestController
@RequestMapping("/provider")
public class ProviderDemoController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private String port;


    @RequestMapping("/example")
    public String example(){
        return "call success, applicationName = "+ applicationName +" port = " + port;
    }

    /**
     * 模拟openFeign调用超时
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/timeout")
    public String timeout() throws InterruptedException {
        Thread.sleep(5000);
        return "timeout";
    }
}
