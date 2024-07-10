package com.chenjw.review.factory_demo;

public class MainTest {


    public static void main(String[] args) {
        MoveableFactory moveableFactory1 = BusFactory.getInstance();
        moveableFactory1.createMoveable().move();

        MoveableFactory moveableFactory2 = CarFactory.getInstance();
        moveableFactory2.createMoveable().move();

    }
}
