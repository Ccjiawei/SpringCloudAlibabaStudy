package com.chenjw.controller;

import com.chenjw.common.Result;
import com.chenjw.feignClient.DemoFeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/17 17:47
 */
@RestController
public class DemoController {

    @Resource
    private DemoFeignClient demoFeignClient;

    @RequestMapping("feignTest")
    public Result feignTest(){
        return demoFeignClient.demo();
    }

    @RequestMapping("feignTimeout")
    public Result feignTimeout(){
        return demoFeignClient.timeout();
    }
}
