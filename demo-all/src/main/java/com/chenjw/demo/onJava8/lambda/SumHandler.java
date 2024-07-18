package com.chenjw.demo.onJava8.lambda;


@FunctionalInterface
public interface SumHandler {
    int sum(int a, int b);
}

class Xclass{
    static int x = 2;
    static int y = 5;

    public Xclass(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
//        SumHandler sumHandler = (a, b) -> a + b;
        SumHandler sumHandler = Xclass::sum;
        System.out.println(sumHandler.sum(Xclass.x, Xclass.y));
    }
}
