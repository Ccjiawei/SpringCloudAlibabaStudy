package com.chenjw.fallback;

import com.chenjw.common.Result;
import com.chenjw.feignClient.DemoFeignClient;
import org.springframework.stereotype.Component;

/**
 * 服务降级回调
 */
@Component
public class MyFallBack implements DemoFeignClient {

    @Override
    public Result demo() {
        return Result.error("未知错误");
    }

    @Override
    public Result timeout() {
        return Result.error("调用超时");
    }
}
