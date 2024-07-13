package com.chenjw.review.proxy_demo.dynamic_proxy.cglib_proxy;

public class UserServiceImpl implements UserService{
    @Override
    public void read(String bookname) {
        System.out.println("UserServiceImpl read book " + bookname);
        walk("road");
    }

    @Override
    public void walk(String roadname) {
        System.out.println("UserServiceImpl walk road " + roadname);
    }
}
