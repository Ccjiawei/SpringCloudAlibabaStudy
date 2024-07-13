package com.chenjw.review.factory_demo.factorymethod_demo;

public class CatFactory extends AnimalFactory{

    private CatFactory(){}

    public static CatFactory getDefaultInstance(){
        return CatFactory.defaultCatFactory.INSTANCE;
    }

    public static class defaultCatFactory{
        public static final CatFactory INSTANCE = new CatFactory();
    }

    @Override
    public Animal createAnimal(String name, String sex, int age) {
        return new Cat(name, sex, age);
    }
}
