package com.chenjw.review.factory_demo.factorymethod_demo;

public class Tiger extends AbstractAnimal implements Animal{

    public Tiger(String name, String sex, int age) {
        super(name, sex, age);
    }

    @Override
    public void eat() {
        System.out.println("吃肉");
    }

    @Override
    public void sleep() {
        System.out.println("睡");
    }

    @Override
    public void drink() {
        System.out.println("喝水");
    }
}
