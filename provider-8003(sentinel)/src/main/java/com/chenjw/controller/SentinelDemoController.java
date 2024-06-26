package com.chenjw.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.chenjw.service.SentinelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试SpringCloudAlibaba-Sentinel的流控、熔断模式
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/17 14:55
 */
@RestController
public class SentinelDemoController {

    @Resource
    private SentinelService sentinelService;


    @RequestMapping("/demo1")
    public String demo1(){
        return "sentinel1";
    }

    @RequestMapping("/demo2")
    public String demo2(){
        return "sentinel2";
    }

    /************@SentinelResource**************/

    @RequestMapping("/demo3")
    public String demo3(){
        return sentinelService.shared();
    }

    @RequestMapping("/demo4")
    public String demo4(){
        return sentinelService.shared();
    }

    /************fallback**************/

    @RequestMapping("/demo5")
    @SentinelResource(value = "demo5", fallback = "fallback")
    public String demo5(Integer id){
        if (id == null)
            throw new NullPointerException("id不能为空");
        return "demo5";
    }

    /**
     * fallback demo5 的服务器异常回调
     * @param id
     * @param throwable
     * @return
     */
    public String fallback(Integer id, Throwable throwable){
        return "服务器异常 :" + throwable.getMessage();
    }


    /************blockhandler**************/

    @RequestMapping("/demo6")
    @SentinelResource(value = "demo6", blockHandler = "blockHandler")
    public String demo6(Integer id){
        return "demo6";
    }

    /**
     * blockHandler demo6的流控异常回调
     * @param id
     * @param blockException
     * @return
     */
    public String blockHandler(Integer id, BlockException blockException){
        return "您被限制访问 :" + id;
    }

    /************熔断规则**************/

    @RequestMapping("/demo7")
    @SentinelResource(value = "demo7")
    public String demo7(Integer id) throws InterruptedException {
        Thread.sleep(1500);
        return "demo7";
    }


    /************热点规则**************/

    @RequestMapping("/demo8")
    @SentinelResource(value = "test_hotkey")
    public String demo8(@RequestParam(value = "hotkey", required = false)Integer hotkey) {
        return "demo8";
    }

    /************nacos持久化sentinel配置测试**************/

    @RequestMapping("/test01")
    public String test01() {
        return "test01";
    }

}
