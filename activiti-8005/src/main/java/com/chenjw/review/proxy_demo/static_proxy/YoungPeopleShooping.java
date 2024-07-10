package com.chenjw.review.proxy_demo.static_proxy;

public class YoungPeopleShooping implements Shooping{

    private String youngPeopleName;

    @Override
    public void buy(String name) {
        System.out.println(name + " young people buy");
    }

    public String getYoungPeopleName() {
        return youngPeopleName;
    }

    public void setYoungPeopleName(String youngPeopleName) {
        this.youngPeopleName = youngPeopleName;
    }
}
