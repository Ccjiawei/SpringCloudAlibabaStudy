package com.chenjw.demo.onJava8.lambda;

public class LambdaDemo {
}


/**
 * 方法引用-lambda表达式
 */
class X{
    String f(){
        return "X";
    }
}

interface MakeString{
    String make();
}
interface TransformX{
    String transform(X x);
}

class UnboundMethodReference{
    public static void main(String[] args) {
        X x = new X();
        MakeString makeString = x::f;

        TransformX transformX = X::f;
        String transform = transformX.transform(x);

        String make = makeString.make();

        System.out.println(make);
        System.out.println(transform);

        Runnable aNew = X::new;
    }
}

/**
 * 构造方法引用-lambda表达式
 */
class Cat{
    String name;
    int age = -1;
    Cat(){name = "cat";}
    Cat(String name){this.name = name;}
    Cat(String name, int age){this.name = name; this.age = age;}
}
interface MakeNoArgs<T>{
    T make();
}
interface Make1Args<T>{
    T make(String name);
}
interface Make2Args<T>{
    T make(String name, int age);
}
class CatFactory{
    public static void main(String[] args) {
        MakeNoArgs<Cat> makeNoArgsCat = Cat::new;
        Make1Args<Cat> make1ArgsCat = Cat::new;
        Make2Args<Cat> make2ArgsCat = Cat::new;

        Cat cat = makeNoArgsCat.make();
        Cat cat1 = make1ArgsCat.make("cat1");
        Cat cat2 = make2ArgsCat.make("cat2", 2);

        System.out.println(cat.name + " " + cat.age);
        System.out.println(cat1.name + " " + cat1.age);
        System.out.println(cat2.name + " " + cat2.age);

        Make2Args<Cat> cat3 = (name, age) ->  new Cat(name, age);
        System.out.println(cat3.make("cat3", 3).name);
    }
}