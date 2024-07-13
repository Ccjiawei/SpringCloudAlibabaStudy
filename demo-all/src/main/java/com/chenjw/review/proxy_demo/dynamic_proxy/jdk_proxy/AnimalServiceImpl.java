package com.chenjw.review.proxy_demo.dynamic_proxy.jdk_proxy;

public class AnimalServiceImpl implements AnimalService{
    @Override
    public void eat(String food) {
        System.out.println("AnimalServiceImpl eat " + food);
    }
}
