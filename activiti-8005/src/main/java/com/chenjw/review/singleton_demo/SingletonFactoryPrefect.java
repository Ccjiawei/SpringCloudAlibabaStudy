package com.chenjw.review.singleton_demo;

public class SingletonFactoryPrefect {

    private SingletonFactoryPrefect(){

    }

    /*
    * 静态内部类方式
    * 线程安全
    * */
    private static class SingletonFactoryPrefectHolder{
        private static final SingletonFactoryPrefect instance = new SingletonFactoryPrefect();
    }

    public static SingletonFactoryPrefect getInstance(){
        return SingletonFactoryPrefectHolder.instance;
    }

    public static void main(String[] args) {
        for (int i = 0 ; i < 100 ; i++){
            new Thread(() -> {
                SingletonFactoryPrefect instance = SingletonFactoryPrefect.getInstance();
                System.out.println(instance.hashCode());;
            }).start();
        }
    }
}



