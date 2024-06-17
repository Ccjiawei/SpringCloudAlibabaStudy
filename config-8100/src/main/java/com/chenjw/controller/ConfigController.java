package com.chenjw.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/17 11:22
 */
@RestController
@RefreshScope //实时刷新配置中心 xxx.yaml
public class ConfigController {

    @Value("${config.info}")
    private String info;


    @RequestMapping("/info")
    public String info(){
        return "info : "+ info;
    }


}
