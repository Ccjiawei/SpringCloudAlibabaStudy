package com.chenjw.review.factory_demo;

/**
 *  小汽车
 */
public class Car implements Moveable{

    @Override
    public void move() {
        System.out.println("小汽车move.......");
    }
}
