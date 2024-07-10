package com.chenjw.review.proxy_demo.dynamic_proxy.jdk_proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class MainTest {

    /**
     * jdk动态代理
     */
    @Test
    public void jdkProxyDemo(){

        //创建代理对象
        Object object = Proxy.newProxyInstance(
                AnimalServiceImpl.class.getClassLoader(),
                AnimalServiceImpl.class.getInterfaces(),
                new AnimalServiceProxy(new AnimalServiceImpl())
        );

        Object object_2 = Proxy.newProxyInstance(
                AnimalServiceImpl_2.class.getClassLoader(),
                AnimalServiceImpl_2.class.getInterfaces(),
                new AnimalServiceProxy(new AnimalServiceImpl_2())
        );

        if(object instanceof AnimalService){
            AnimalService animalService = (AnimalService) object;
            animalService.eat("面包");
        }
        System.out.println("----------------");
        if(object_2 instanceof AnimalService){
            AnimalService animalService = (AnimalService) object_2;
            animalService.eat("汉堡");
        }
    }

}
