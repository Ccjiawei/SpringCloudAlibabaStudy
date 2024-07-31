package com.chenjw.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;



/**
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/18 16:44
 */
@FeignClient(value = "seata-stock")
@Component
public interface StockClient {

    @GetMapping("reduceStock")
    String reduceStock(@RequestParam("id") Integer id, @RequestHeader("headerValue")String headerValue);
}
