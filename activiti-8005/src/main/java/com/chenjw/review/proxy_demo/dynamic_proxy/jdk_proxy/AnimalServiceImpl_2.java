package com.chenjw.review.proxy_demo.dynamic_proxy.jdk_proxy;

public class AnimalServiceImpl_2 implements AnimalService{
    @Override
    public void eat(String food) {
        System.out.println("AnimalServiceImpl_2 eat " + food);
    }
}
