package com.chenjw.review.factory_demo;

/**
 *  Car抽象工厂
 */
public class CarFactory extends MoveableFactory{

    private CarFactory(){

    }

    public static class DefaultCarFactory {
        public static final CarFactory carFactory = new CarFactory();
    }

    public static CarFactory getInstance() {
        return DefaultCarFactory.carFactory;
    }

    @Override
    public Moveable createMoveable() {
        return new Car();
    }
}
