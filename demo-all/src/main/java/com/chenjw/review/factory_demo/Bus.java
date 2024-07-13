package com.chenjw.review.factory_demo;

/**
 *  公共汽车
 */
public class Bus implements Moveable{

    @Override
    public void move() {
        System.out.println("公共汽车move.......");
    }
}
