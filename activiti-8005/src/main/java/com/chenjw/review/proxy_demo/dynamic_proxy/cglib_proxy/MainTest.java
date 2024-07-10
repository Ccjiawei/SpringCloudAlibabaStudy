package com.chenjw.review.proxy_demo.dynamic_proxy.cglib_proxy;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

public class MainTest {


    /**
     * cglib动态代理
     */
    @Test
    public void cglibProxy(){

        Enhancer enhancer = new Enhancer(); // 创建Enhancer对象
        enhancer.setSuperclass(UserServiceImpl.class);  // 设置父类
        enhancer.setCallback(new UserServiceProxy(new UserServiceImpl())); // 设置回调
        Object object = enhancer.create();

        if (object instanceof UserService){
            UserService userService = (UserService) object;
            userService.read("三国演义");
            userService.walk("河北大街");
        }

        System.out.println("==============");

        Enhancer enhancer2 = new Enhancer(); // 创建Enhancer对象
        enhancer2.setSuperclass(UserServiceImpl_2.class);  // 设置父类
        enhancer2.setCallback(new UserServiceProxy(new UserServiceImpl_2())); // 设置回调
        Object object2 = enhancer2.create();

        if (object2 instanceof UserService){
            UserService userService = (UserService) object2;
            userService.read("西游记");
            userService.walk("南京大街");
        }

    }
}
