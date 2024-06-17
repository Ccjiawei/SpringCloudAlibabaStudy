package com.chenjw.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 调用服务提供方需要的FeignClient
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/17 17:46
 */
@Component
@FeignClient("provider")
public interface DemoFeignClient {

    @RequestMapping("/provider/example")
    public String demo();
}
