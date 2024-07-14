package com.chenjw.controller.starterdemo;

public class TestClassLoadDemo extends ClassLoader {

    static {
        System.out.print("a");
    }

    public TestClassLoadDemo(){
        System.out.print("b");
    }

    /**
     * 静态代码块 类加载只执行一次   子类构造器在父类构造器之后执行
     * @param args
     */
    public static void main(String[] args) {
        TestClassLoadDemo2 demo2 = new TestClassLoadDemo2(); //a 1 b 2    b 2
        demo2 = new TestClassLoadDemo2();
    }

}

class TestClassLoadDemo2 extends TestClassLoadDemo{

    static {
        System.out.print("1");
    }

    public TestClassLoadDemo2(){
        System.out.print("2");
    }
}


