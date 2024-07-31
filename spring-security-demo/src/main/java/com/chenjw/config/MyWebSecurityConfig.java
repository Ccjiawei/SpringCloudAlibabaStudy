package com.chenjw.config;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 基于内存的用户、URL权限配置:
 * 我们可以通过自定义类继承 WebSecurityConfigurerAdapter，从而实现对 Spring Security 更多的自定义配置。
 * 比如下面样例我们就配置了两个用户，以及他们对应的角色（这种方式只适合用于测试、开发环境不适用于生产）
 */
//@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    // 指定密码的加密方式
//    @Bean
//    @Qualifier("passwordEncoderIn")
//    @Order(100)
//    public PasswordEncoder passwordEncoder(){
//        return new PasswordEncoder() {
//            @Override
//            public String encode(CharSequence charSequence) {
//                return charSequence.toString();
//            }
//
//            @Override
//            public boolean matches(CharSequence charSequence, String s) {
//                return Objects.equals(charSequence.toString(), s);
//            }
//        };
//    }
//
//    // 配置用户及其对应的角色
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("chenjw")
//                .password("11")
//                .roles("ADMIN","DBA")
//                .and()
//                .withUser("chenjw2")
//                .password("11")
//                .roles("ADMIN","USER");
//    }
//
//    // 配置 URL 访问权限
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests()// 开启 HttpSecurity 配置
////                .antMatchers("/admin/**").hasRole("admin")// admin/** 模式URL必须具备ADMIN角色
////                .antMatchers("/user/**").access("hasAnyRole('user','admin')")// 该模式需要user或admin角色
////                .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')") // 需ADMIN和DBA角色
////                .antMatchers("/").permitAll()
////                .and()
////                .formLogin()
////                .and()
////                .logout()
////                .logoutSuccessUrl("/")
////                .permitAll();
//        http.authorizeRequests() // 开启 HttpSecurity 配置
//                .antMatchers("/admin/**").hasRole("ADMIN") // admin/** 模式URL必须具备ADMIN角色
//                .antMatchers("/user/**").access("hasAnyRole('ADMIN','USER')") // 该模式需要ADMIN或USER角色
//                .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')") // 需ADMIN和DBA角色
//                .anyRequest().authenticated() // 用户访问其它URL都必须认证后访问（登录后访问）
//                .and().formLogin().loginProcessingUrl("/login").permitAll() // 开启表单登录并配置登录接口
//                .and().csrf().disable(); // 关闭csrf
//
//        /**
//         * formLogin() 方法表示开启表单登录，即我们之前看到的登录页面。
//         * loginProcessingUrl() 方法配置登录接口为“/login”，即可以直接调用“/login”接口，发起一个 POST 请求进行登录，登录参数中用户名必须为 username，密码必须为 password，配置 loginProcessingUrl 接口主要是方便 Ajax 或者移动端调用登录接口。
//         * permitAll() 表示和登录相关的接口都不需要认证即可访问。
//         */
//    }

}
