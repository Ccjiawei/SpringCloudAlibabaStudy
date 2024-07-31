package com.chenjw.service.impl;

import com.chenjw.bean.Order;
import com.chenjw.feign.StockClient;
import com.chenjw.mapper.OrderMapper;
import com.chenjw.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/18 16:41
 */
@Service("orderServiceB")
public class OrderServiceImplB implements OrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private StockClient stockClient;

    @Override
    @GlobalTransactional// 开启分布式事务
    public void addOrder() {
        System.out.println("==========OrderServiceImplB===========");
        Order order = new Order(null, 1, "新增订单");
        orderMapper.insert(order);
//        stockClient.reduceStock(1);
    }
}
