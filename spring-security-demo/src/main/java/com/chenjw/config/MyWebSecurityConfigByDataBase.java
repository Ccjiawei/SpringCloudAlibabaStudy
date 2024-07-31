package com.chenjw.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 */
@Configuration
public class MyWebSecurityConfigByDataBase extends WebSecurityConfigurerAdapter {

    @Resource
    @Qualifier("userServiceB")
    private UserDetailsService userService;

    // 指定密码的加密方式
    @Bean
    @Primary
    @Qualifier("passwordEncoder")
    @Order(1)
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // 配置用户及其对应的角色
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
        auth.userDetailsService(userService);
    }

    // 配置 URL 访问权限
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() // 开启 HttpSecurity 配置
                .antMatchers("/admin/**").hasRole("ADMIN") // admin/** 模式URL必须具备ADMIN角色
                .antMatchers("/user/**").access("hasAnyRole('ADMIN','USER')") // 该模式需要ADMIN或USER角色
                .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')") // 需ADMIN和DBA角色
                .antMatchers("/gid").permitAll() // 配置不需要认证即可访问
                .anyRequest().authenticated() // 用户访问其它URL都必须认证后访问（登录后访问）
                .and().formLogin().loginProcessingUrl("/login").permitAll() // 开启表单登录并配置登录接口
                .and().csrf().disable(); // 关闭csrf

       /**
         * formLogin() 方法表示开启表单登录，即我们之前看到的登录页面。
         * loginProcessingUrl() 方法配置登录接口为“/login”，即可以直接调用“/login”接口，发起一个 POST 请求进行登录，登录参数中用户名必须为 username，密码必须为 password，配置 loginProcessingUrl 接口主要是方便 Ajax 或者移动端调用登录接口。
         * permitAll() 表示和登录相关的接口都不需要认证即可访问。*/

    }

}
