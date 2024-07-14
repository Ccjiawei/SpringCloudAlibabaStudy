package com.chenjw.review.juc;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {

    private final static Random random = new Random();

    public static void main(String[] args) {

        List<Integer> idList = Arrays.asList(1,2,3,4,5,6,7);
        CountDownLatch countDownLatch = new CountDownLatch(idList.size());

        for (Integer id : idList) {
            new Thread(new Task(id, countDownLatch)).start();
        }

        try {
//            countDownLatch.await(); // 阻塞主线程
            countDownLatch.await(2000, TimeUnit.MILLISECONDS); // 阻塞主线程
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("主线程退出....");


    }

    static class Task implements Runnable{

        private Integer id;
        private CountDownLatch countDownLatch;

        public Task(Integer id, CountDownLatch countDownLatch) {
            this.id = id;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println("执行"+id+"start：");
            int seconds = random.nextInt(10);
            try {
                Thread.sleep(seconds * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("执行"+id+"耗时："+seconds);
            countDownLatch.countDown(); // 递减计数器
        }
    }

}
