package com.chenjw.review.proxy_demo.dynamic_proxy.jdk_proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * jdk动态代理  InvocationHandler
 * @author chenjw
 * @date 2024/7/10
 * @time 21:14
 * @description 代理实现了接口的目标类
 */
public class AnimalServiceProxy implements InvocationHandler {
    private Object obj; // 目标类

    public AnimalServiceProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置增强");
        Object invoke = method.invoke(obj, args); // 调用目标类的方法
        System.out.println("后置增强");
        return invoke;
    }
}
