package com.chenjw.demo.onJava8.lambda;

@FunctionalInterface
public interface SingingHandler<T> {

    void singing(String singername);

    default void defaultMethod(T t){
        System.out.println("defaultMethod--" + t);
    }
}
