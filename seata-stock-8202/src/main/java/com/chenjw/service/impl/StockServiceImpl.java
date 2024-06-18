package com.chenjw.service.impl;

import com.chenjw.mapper.StockMapper;
import com.chenjw.service.StockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/18 16:52
 */
@Service
public class StockServiceImpl implements StockService {

    @Resource
    private StockMapper stockMapper;

    @Override
    public void reduceStock(Integer id) {
        stockMapper.reduceStock(id);
    }
}
