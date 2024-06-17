package com.chenjw.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/17 16:59
 */
public class MyBlockHandler {

    public String blockHandler(Integer id, BlockException blockException){
        return "您被限制访问 :" + id;
    }

}
