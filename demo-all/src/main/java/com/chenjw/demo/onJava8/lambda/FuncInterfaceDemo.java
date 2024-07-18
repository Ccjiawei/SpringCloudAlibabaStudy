package com.chenjw.demo.onJava8.lambda;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class FuncInterfaceDemo {
}

class Foo{
}

class Bar{
    Foo f;
    Bar(Foo f){
        this.f = f;
    }
}
class IBaz{
    int i;
    IBaz(int i){
        this.i = i;
    }

    public static void main(String[] args) throws IOException {
//        Function<Foo, Bar> f1 = f -> new Bar(f);
//        f1.apply(new Foo());
//        f1.compose(f -> new Foo());
//
//        IntFunction<IBaz> f2 = i -> new IBaz(i);
//        f2.apply(123);
//        new ArrayList<>().stream().forEach(System.out::println);
//        Stream.of("good", "boy").forEach(System.out::println);


        Set<String> set = new HashSet<>(Arrays.asList("good boy cc".split(" ")));
//        set.stream().map(s -> s.toUpperCase()).forEach(System.out::print);
//
//        set.stream().flatMap(s -> Arrays.stream(s.split(""))).forEach(System.out::print);

        set.stream()
                .limit(2)
                .skip(1)
                .map(s -> s.toUpperCase())
                .peek(s -> System.out.println("peek: " + s))
                .sorted(Comparator.reverseOrder())
                .distinct()
//                .filter()
                .forEach(System.out::print);

//        Files.lines(new File("").toPath()).forEach(System.out::println);
//        range(0, 10)
    }
}
