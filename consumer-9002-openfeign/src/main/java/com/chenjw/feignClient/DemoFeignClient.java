package com.chenjw.feignClient;

import com.chenjw.common.Result;
import com.chenjw.fallback.MyFallBack;
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
@FeignClient(value = "provider", fallback = MyFallBack.class)
public interface DemoFeignClient {

    @RequestMapping("/provider/example")
    Result demo();

    @RequestMapping("/provider/timeout")
    Result timeout();
}
