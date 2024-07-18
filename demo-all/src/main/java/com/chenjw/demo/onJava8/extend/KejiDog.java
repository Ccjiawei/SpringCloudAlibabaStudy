package com.chenjw.demo.onJava8.extend;

/**
 * 构造函数、类成员变量加载顺序
 * 清理顺序与加载顺序相反
 */
class Animal {
    public Animal(){
        System.out.println("Animal()");
    }

    protected void dispose(){
        System.out.println("Animal dispose");
        try {
            super.finalize();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}

class Dog extends Animal {
    public Dog(){
        System.out.println("Dog()");
    }

    @Override
    protected void dispose() {
        System.out.println("Dog dispose");
        super.dispose();
    }
}

public class KejiDog extends Dog {

    static kejiDogInnerClass kejiDogInnerClass;

    public KejiDog(){
        System.out.println("kejiDog()");
        kejiDogInnerClass = new kejiDogInnerClass();
    }

    static class kejiDogInnerClass{
//        private static final KejiDog kejiDog = new KejiDog();
        private Keji1 keji1;
        private Keji2 keji2;

        public kejiDogInnerClass(){
            System.out.println("kejiDogInnerClass()");
            keji1 = new Keji1();
            keji2 = new Keji2();
        }
    }

    @Override
    protected void dispose() {
        System.out.println("kejiDog dispose");
        super.dispose();
    }

    public static void main(String[] args) {
        KejiDog kejiDog = new KejiDog();
        kejiDog.dispose();

        kejiDogInnerClass innerClass = kejiDog.kejiDogInnerClass;
        System.err.println(innerClass.keji1);
        System.err.println(innerClass.keji2);
        /**
         * Animal()
         * Dog()
         * Keji1()
         * Keji2()
         * kejiDog()
         */

        Thread thread =  new Thread(new Runnable(){
            @Override public void run() {
                System.out.println("no lambda");
            }
        });

        Thread t = new Thread(()->{
            System.out.println("use lambda");
        });
    }
}

class Keji1 {
    public Keji1(){
        System.out.println("Keji1()");
    }
    // 嵌套接口
    interface KejiInterface{
        void func();
    }


}

class Keji2 {
    public Keji2(){
        System.out.println("Keji2()");
    }
}