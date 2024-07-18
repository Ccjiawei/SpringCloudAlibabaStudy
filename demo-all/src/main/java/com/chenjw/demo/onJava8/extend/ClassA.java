package com.chenjw.demo.onJava8.extend;

import java.lang.reflect.InvocationTargetException;

public class ClassA {
    public static String name = "123";

    public ClassA(){
    }

//    public ClassA(String name){
//        this.name = name;
//    }

    public String toString() {
        return "ClassA{" +
                "name='" + name + '\''+"}";
            }
}

class ClassB extends ClassA {

    public ClassB(String name) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
//        Constructor<ClassA> constructor = ClassA.class.getDeclaredConstructor();
//        ClassA classA = constructor.newInstance();
//        ClassA.class.getDeclaredField("name").set(classA,name);
        ClassA.name = name;
    }

    public static void main(String[] args) throws NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ClassB classB = new ClassB("chenjw");
        System.out.println(classB);
    }
}
