package com.chenjw.config;

import com.chenjw.bean.MyAppProperties;
import com.chenjw.bean.MyBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MyAppProperties.class)
public class MyConfig {

//    public MyAppProperties myAppProperties(){
//        return new MyAppProperties();
//    }

    @Bean
    public MyBean myBean(MyAppProperties myAppProperties){
        MyBean mybean = MyBean.getDefaultSingletonInstance(myAppProperties.getName(), myAppProperties.getSex());
        System.out.println(mybean.toString());
        return mybean;
    }

}
