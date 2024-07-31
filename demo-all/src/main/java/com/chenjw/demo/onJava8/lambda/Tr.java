package com.chenjw.demo.onJava8.lambda;

public class Tr {
    int a = 0;
    final static String s = "s";
    public int test(int a){
        try{
            this.a = a + 1;
//            System.exit(0);  //不会执行finallly  或者try块Error错误
            return this.a;
        }finally {
            System.out.println("finally");
            this.a = this.a + 1;
            return this.a; //不管有没有return 只要finally块里执行了变量操作，都是返回操作后的值；
        }
    }

    public static void main(String[] args) {
        Tr tr = new Tr();
        tr.test(tr.a);
        System.out.println(tr.a);;
    }
}
