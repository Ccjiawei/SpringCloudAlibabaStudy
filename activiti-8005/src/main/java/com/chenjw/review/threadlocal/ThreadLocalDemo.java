package com.chenjw.review.threadlocal;

public class ThreadLocalDemo implements Runnable {

    ThreadLocal<String> threadLocal = new ThreadLocal<>();

    @Override
    public void run() {
        this.threadLocal.set(Thread.currentThread().getName());
        System.out.println(this.threadLocal.get());
        threadLocal.remove();
    }

    public static void main(String[] args) {
        ThreadLocalDemo demo1 = new ThreadLocalDemo();
        Thread thread1 = new Thread(demo1);
        thread1.start();

        ThreadLocalDemo demo2 = new ThreadLocalDemo();
        Thread thread2 = new Thread(demo2);
        thread2.start();

    }
}
