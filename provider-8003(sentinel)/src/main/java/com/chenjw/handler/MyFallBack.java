package com.chenjw.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/17 16:59
 */
public class MyFallBack {

    public String fallback(Integer id, Throwable throwable){
        return "服务器异常 :" + throwable.getMessage();
    }
}
