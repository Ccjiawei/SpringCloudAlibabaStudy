package com.chenjw.controller;

import com.chenjw.service.OrderService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/18 16:46
 */
@RestController
public class OrderController {

    @Resource
    @Qualifier("orderServiceB")
    private OrderService orderService;

    @RequestMapping("/addOrder")
    public String addOrder() {
        orderService.addOrder();
        return "新增订单成功";
    }

}
