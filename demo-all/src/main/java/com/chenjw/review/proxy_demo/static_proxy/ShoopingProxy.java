package com.chenjw.review.proxy_demo.static_proxy;

public class ShoopingProxy implements Shooping{

    private YoungPeopleShooping youngPeopleShooping;

    public ShoopingProxy(YoungPeopleShooping youngPeopleShooping) {
        this.youngPeopleShooping = youngPeopleShooping;
    }

    @Override
    public void buy(String name) {
        System.out.println("代理增强开始。。。。。。");
        youngPeopleShooping.buy(name);
        System.out.println("代理增强完成。。。。。。");

    }

    public static void main(String[] args) {
        Shooping shooping = new ShoopingProxy(new YoungPeopleShooping());
        shooping.buy("年轻人");
    }
}
