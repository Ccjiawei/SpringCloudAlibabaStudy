package com.chenjw.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.chenjw.service.SentinelService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/17 15:05
 */
@Service
public class SentinelServiceImpl implements SentinelService {

    @Override
    @SentinelResource(value = "shared")
    public String shared() {
        return "shared";
    }
}
