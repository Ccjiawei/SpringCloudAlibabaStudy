package com.chenjw.config;

import com.chenjw.filter.CustomGateWayFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author: Chenjiawei
 * @Date: 2024/6/18 15:43
 */
@Configuration
public class FilterConfig {

    @Bean
    public CustomGateWayFilter provierCustomGateWayFilter(){
        return new CustomGateWayFilter();
    }
}
