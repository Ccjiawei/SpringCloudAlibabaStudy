package com.chenjw.review.singleton_demo;

import java.util.concurrent.locks.ReentrantLock;

public class SingletonFactory {


    private static volatile SingletonFactory instance = null;
    private static final Object obj = new Object();
    static ReentrantLock lock = new ReentrantLock();

    private SingletonFactory(){

    }

    public void show(){
        System.out.println("show, " + instance);
    }


    /**
     * 懒汉式单例模式
     * 线程不安全
     * */
    public static SingletonFactory getInstance(){

        if (instance == null) {
            lock.lock();
            if (instance == null) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                instance = new SingletonFactory();
            }
            lock.unlock();
        }

        return instance;
    }









    public static void main(String[] args) {

//        Class clz = Class.forName("com.chenjw.review.singleton_demo.SingletonFactory");
//        Method method =clz.getMethod("show");
//        method.invoke(s1);

//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                SingletonFactory s = SingletonFactory.getInstance();
//                s.show();
//            }
//        });
//
//        thread1.start();
//
//
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                SingletonFactory s = SingletonFactory.getInstance();
//                s.show();
//            }
//        });
//
//        thread2.start();

        for (int i = 0 ; i < 100 ; i++){
            new Thread(() -> {
                SingletonFactory s = SingletonFactory.getInstance();
                s.hashCode();
                s.show();
            }).start();
        }

    }
}



