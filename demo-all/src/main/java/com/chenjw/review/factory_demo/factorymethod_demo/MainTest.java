package com.chenjw.review.factory_demo.factorymethod_demo;

public class MainTest {

    public static void main(String[] args) {

        for (int i = 1; i < 5; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    AnimalFactory dogFactory = DogFactory.getDefaultInstance();
                    System.out.println(Thread.currentThread().getName() + ":" +dogFactory.hashCode());
                    Animal dog = dogFactory.createAnimal("小狗", "公的", 5);
                    dog.eat();
                    dog.drink();
                    dog.sleep();
                    System.out.println("=========");

                    AnimalFactory catFactory = CatFactory.getDefaultInstance();
                    System.out.println(Thread.currentThread().getName() + ":" +dogFactory.hashCode());
                    Animal cat = catFactory.createAnimal("小猫", "母的", 3);
                    cat.eat();
                    cat.drink();
                    cat.sleep();
                    System.out.println("=========");

                    AnimalFactory tigerFactory = TigerFactory.getDefaultInstance();
                    System.out.println(Thread.currentThread().getName() + ":" +tigerFactory.hashCode());
                    Animal tiger = tigerFactory.createAnimal("老虎", "公的", 10);
                    tiger.eat();
                    tiger.drink();
                    tiger.sleep();
                    System.out.println("=========");
                }
            }).start();
        }


    }
}
