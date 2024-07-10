package com.chenjw.review.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool_A extends ThreadPoolExecutor {


    public ThreadPool_A(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void terminated() {
        super.terminated();
        //关闭线程池时需要做的事情

        System.out.println("线程池关闭.............");
    }
}
