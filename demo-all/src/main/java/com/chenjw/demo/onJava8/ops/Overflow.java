package com.chenjw.demo.onJava8.ops;

import java.io.*;
import java.util.Random;

public class Overflow implements Serializable {
    public static void main(String[] args) {
        int big = Integer.MAX_VALUE;
        System.out.println("big = " + big);
        System.out.println(big*4);

        if(Integer.valueOf(big) == null){

        }
        final String property = System.getProperty("java.version");
        System.out.println(property);


    }

    void s(){
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(""));
            outputStream.writeObject(new Overflow());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

abstract class A{
    public static void main(String[] args) {
        item://item:  标签  标签在java中一般只用于嵌套循环  标签和循环语句之间不能有语句
        // continue item;  跳外层继续循环 break item;   跳出外层不再继续循环
        for (int j=0; j<5;j++) {
            for (int i = 0; i < 5; i++) {
                if (i == 0)
                    continue;
                if (i == 1)
                    break;
                if (i == 2)
                    continue item;
                if (i == 3)
                    break item;
            }
        }
        //'a' char 类型
        int c = new Random().nextInt(26) + 'a';

    }
}

interface B{}
