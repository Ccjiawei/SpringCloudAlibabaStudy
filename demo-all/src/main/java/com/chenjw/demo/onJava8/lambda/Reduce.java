package com.chenjw.demo.onJava8.lambda;

import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;
class Reduce {
    public int a;
    public static void main(String[] args) {

        final Optional<A> reduce = Stream.generate(A::supply).limit(10).distinct().peek(System.out::println)
                .reduce((a, b) -> a.size > b.size ? a : b);
        System.out.println("-----");
        reduce.ifPresent(a -> System.out.println(a.size));

        System.out.println(Integer.toBinaryString(2<<2));

    }
}

class A{

    static Random random = new Random(47);
    static final int SIZE = 100;
    int size;

    public A(int size){
        this.size = size;
    }

    static A supply(){
        return new A(random.nextInt(SIZE));
    }

    @Override
    public String toString() {
        return "A{" +
                "size=" + size +
                '}';
    }
}
