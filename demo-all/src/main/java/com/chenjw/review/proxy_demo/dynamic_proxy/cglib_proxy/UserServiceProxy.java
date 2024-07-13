package com.chenjw.review.proxy_demo.dynamic_proxy.cglib_proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *  MethodInterceptor
 * @author chenjw
 * @date 2024/7/10
 * @description cglib动态代理  继承目标类方式实现
 */
public class UserServiceProxy implements MethodInterceptor {

    private Object obj; // 被代理对象

    public UserServiceProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("前置增强");
        Object object = methodProxy.invokeSuper(o, objects); // 调用被代理类的方法  invokeSuper代理方法中的方法如果有增强可以重入
        System.out.println("后置增强");
        return object;
    }
}
