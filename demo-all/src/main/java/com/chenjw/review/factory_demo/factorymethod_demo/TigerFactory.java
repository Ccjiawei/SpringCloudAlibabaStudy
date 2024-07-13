package com.chenjw.review.factory_demo.factorymethod_demo;

public class TigerFactory extends AnimalFactory{

    private TigerFactory(){

    }

    public static class defaultTigerFactory {
        public static final TigerFactory INSTANCE = new TigerFactory();
    }

    public static TigerFactory getDefaultInstance() {
        return defaultTigerFactory.INSTANCE;
    }

    @Override
    public Animal createAnimal(String name, String sex, int age) {
        return new Tiger(name, sex, age);
    }
}
