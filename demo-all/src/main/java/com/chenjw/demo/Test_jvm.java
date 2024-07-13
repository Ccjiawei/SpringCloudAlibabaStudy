package com.chenjw.demo;

public class Test_jvm {

    public static void main(String[] args) {
        Test_jvm jvm = new Test_jvm();
        jvm.jvm();
    }

    private int jvm() {
        int a = 1;
        int b = 2;
        int c = a + b;

        System.out.println(c);
        return c;
    }
}
