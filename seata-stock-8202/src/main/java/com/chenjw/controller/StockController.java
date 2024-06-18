package com.chenjw.controller;

import com.chenjw.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/18 16:53
 */
@RestController
public class StockController {
    @Resource
    private StockService stockService;

    @GetMapping("/reduceStock")
    public String reduceStock(@RequestParam("id") Integer id) {
        int i = 1 / 0;
        System.out.println("请求来了");
        stockService.reduceStock(id);
        return "减库存成功";
    }

}
