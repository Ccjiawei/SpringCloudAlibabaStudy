package com.chenjw.review.proxy_demo.dynamic_proxy.cglib_proxy;

public class UserServiceImpl_2 implements UserService{
    @Override
    public void read(String bookname) {
        System.out.println("UserServiceImpl_2 read book " + bookname);
        walk("road");
    }

    @Override
    public void walk(String roadname) {
        System.out.println("UserServiceImpl_2 walk road " + roadname);
    }
}
