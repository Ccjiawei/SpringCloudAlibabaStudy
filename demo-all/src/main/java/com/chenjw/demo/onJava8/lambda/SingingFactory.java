package com.chenjw.demo.onJava8.lambda;

@FunctionalInterface
public interface SingingFactory<T> {
    T create(String name, String gender, String title);
}
