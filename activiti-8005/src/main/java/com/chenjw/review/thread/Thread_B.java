package com.chenjw.review.thread;

public class Thread_B implements Runnable{

    private Object obj = new Object();

    @Override
    public void run() {
        synchronized (obj) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("b线程执行结束");
        }
    }
}
