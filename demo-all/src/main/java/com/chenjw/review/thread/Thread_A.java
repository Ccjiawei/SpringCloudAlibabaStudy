package com.chenjw.review.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Thread_A extends Thread{

    private Object obj = new Object();


    @Override
    public void run() {
        synchronized (obj) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("a线程执行结束");
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread_A thread_a = new Thread_A();
        thread_a.start();

        Thread thread_b = new Thread(new Thread_B());
        thread_b.start();

        FutureTask<String> futureTask = new FutureTask(new Thread_C());
        Thread thread_c = new Thread(futureTask);
        thread_c.start();
        System.out.println(futureTask.get());


        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Thread_B());

        System.out.println("main线程执行结束");


    }
}
