package com.chenjw.config;

import com.chenjw.bean.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public MyBean myBean(){
        MyBean mybean = MyBean.getDefaultSingletonInstance("chenjw", "male");
        System.out.println(mybean.toString());
        return mybean;
    }

}
