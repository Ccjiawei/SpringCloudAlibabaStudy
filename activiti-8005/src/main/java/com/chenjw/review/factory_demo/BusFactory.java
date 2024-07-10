package com.chenjw.review.factory_demo;

/**
 *  Bus抽象工厂
 */
public class BusFactory extends MoveableFactory{

    private BusFactory(){
    }

    public static class DefaultBusFactory{
        public static final BusFactory busFactory = new BusFactory();
    }

    public static BusFactory getInstance(){
        return DefaultBusFactory.busFactory;
    }


    @Override
    public Moveable createMoveable() {
        return new Bus();
    }
}
