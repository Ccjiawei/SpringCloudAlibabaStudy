package com.chenjw.review.thread;

import java.util.concurrent.Callable;

public class Thread_C implements Callable {



    @Override
    public Object call() throws Exception {
        String str = "执行了回调" ;
        return str;
    }
}
