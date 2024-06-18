package com.chenjw.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenjw.bean.Order;

/**
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/18 16:40
 */
public interface OrderMapper extends BaseMapper<Order> {
    void addOrder(Order order);
}

