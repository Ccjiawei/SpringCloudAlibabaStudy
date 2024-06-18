package com.chenjw.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * 除了在yml中配置，配置类也可以进行路由规则的配置，注入Spring容器，返回一个RouteLocator对象，方法入参为 RouteLocatorBuilder
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/18 15:02
 */
//@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder){
        // 构建多个路由routes
        RouteLocatorBuilder.Builder routes = builder.routes();
        // 具体路由地址
        /**
         * 例如 ：http://localhost:8050/consumer/consumer/demo9
         */
        routes.route("consumer", r -> r.path("/consumer/**").uri("http://localhost:9001/consumer")).build();
        // 返回所有路由规则
        return routes.build();
    }



}
