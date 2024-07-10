package com.chenjw.review.factory_demo.factorymethod_demo;

public class Cat extends AbstractAnimal implements Animal{


    public Cat(String name, String sex, int age) {
        super(name, sex, age);
    }

    @Override
    public void eat() {
        System.out.println(this.getName() + "cat eat");
    }

    @Override
    public void sleep() {
        System.out.println(this.getName() + "cat sleep");
    }

    @Override
    public void drink() {
        System.out.println(this.getName() + "cat drink");
    }
}
