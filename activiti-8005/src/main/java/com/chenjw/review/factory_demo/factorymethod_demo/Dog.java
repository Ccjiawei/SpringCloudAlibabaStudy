package com.chenjw.review.factory_demo.factorymethod_demo;

public class Dog extends AbstractAnimal implements Animal{


    public Dog(String name, String sex, int age) {
        super(name, sex, age);
    }

    @Override
    public void eat() {
        System.out.println(this.getName() + "dog eat");
    }

    @Override
    public void sleep() {
        System.out.println(this.getName() + "dog sleep");
    }

    @Override
    public void drink() {
        System.out.println(this.getName() + "dog drink");
    }
}
