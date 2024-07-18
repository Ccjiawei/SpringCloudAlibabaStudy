package com.chenjw.demo.onJava8.extend;

public class Parcel8 {
    public Wrapping wrapping(int x){
        return new Wrapping(x) {
            public int value() {
                return super.value() * 47;
            }
        };
    }

    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Wrapping w = p.wrapping(10);
        System.out.println(w.value());



//        List<String> list = Arrays.asList("1","2","3");
//        list.forEach(System.out::println);
//        list.forEach(each -> System.out.println(each));

//        record Point(int x, int y) {
//            public String toString() {
//                return "(" + x + "," + y + ")";
//            }
//        };
//
//        var a = new Point(1,2);
//        System.out.println(a);
        System.out.println(jiecheng(4));
    }
    public static int jiecheng(int n){
        while (n >= 2){
            return n * jiecheng(n - 1);
        }
        return n;
    }
}

/**
 * 递归
 */
class RecursiveFibonacci{
    IntCall fib;
    public RecursiveFibonacci(){
        fib = n -> n == 0 ? 0 : n == 1 ? 1 : fib.call(n - 1) + fib.call(n - 2);
    }
    int fibonacci(int n){return fib.call(n);}

    public static void main(String[] args) {
        RecursiveFibonacci rf = new RecursiveFibonacci();
        for (int i = 0; i <= 10; i++){
            System.out.println(rf.fibonacci(i));
        }

    }
}
interface IntCall{
    int call(int n);
}

/**
 *  初识FunctionalInterface
 */
@FunctionalInterface
interface Callable{
    void call(String n);
}

class Deccribe{
    void show(String msg){
        System.out.println(msg + "-des");
    }

    public static void main(String[] args) {
        Deccribe d = new Deccribe();
        Callable c = d::show;
        c.call("hello");
    }

}













