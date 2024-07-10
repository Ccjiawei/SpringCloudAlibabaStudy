package com.chenjw.review.factory_demo.factorymethod_demo;

public class DogFactory extends AnimalFactory{

    private DogFactory(){}

    public static DogFactory getDefaultInstance(){
        return defaultDogFactory.INSTANCE;
    }

    public static class defaultDogFactory{
        public static final DogFactory INSTANCE = new DogFactory();
    }

    @Override
    public Animal
    createAnimal(String name, String sex, int age) {
        return new Dog(name, sex, age);
    }
}
