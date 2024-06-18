package com.chenjw.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义过滤器，需要实现GlobalFilter和Ordered接口，Ordered接口用于设置过滤器的优先级
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/18 15:40
 */
public class CustomGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 请求前
        System.out.println("请求前...");
        MultiValueMap<String, String> queryParams = exchange.getRequest().getQueryParams();
        System.out.println("请求参数：" + queryParams);
        Mono<Void> filter = chain.filter(exchange);
        // 其他过滤器执行后的请求结果
        System.out.println("请求后...");
        ServerHttpResponse response = exchange.getResponse();
        if (!queryParams.containsKey("token")) {
            response.setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return response.setComplete();
        }

        System.out.println(response.getStatusCode());
        return filter;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
