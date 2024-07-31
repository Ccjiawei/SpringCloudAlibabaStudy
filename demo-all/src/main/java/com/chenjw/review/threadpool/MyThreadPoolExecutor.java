package com.chenjw.review.threadpool;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;

public class MyThreadPoolExecutor {

    private ExecutorService executor;

    public MyThreadPoolExecutor(int corePoolSize) {
        this(corePoolSize, corePoolSize, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
    }

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        this.executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public void execute(Runnable task) {
        executor.execute(task);
    }

    public void shutdown() {
        executor.shutdown();
    }

    public boolean isTerminated() {
        return executor.isTerminated();
    }

}

class Main {
    public static void main(String[] args) {
        MyThreadPoolExecutor customThreadPool = new MyThreadPoolExecutor(5);

        for (int i = 0; i < 10; i++) {
            int taskId = i;
            customThreadPool.execute(() -> {
                System.out.println("Task ID: " + taskId + ", Thread Name: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // 模拟耗时操作
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        customThreadPool.shutdown();
        while (!customThreadPool.isTerminated()) {
            // 等待所有任务完成
        }
        System.out.println("All tasks completed.");

        final int[] array = new Random(47).ints(0, 1000).limit(100).toArray();
        System.out.println(Arrays.toString(array));
    }
}
