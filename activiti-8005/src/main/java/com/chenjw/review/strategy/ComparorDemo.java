package com.chenjw.review.strategy;

public class ComparorDemo implements Comparable<ComparorDemo>{


    private int value;

    public ComparorDemo(int value) {
        this.value = value;
    }


    @Override
    public int compareTo(ComparorDemo o) {
        return value - o.value;
    }


    public static void main(String[] args) {
        ComparorDemo[] comparorDemoArrys = new ComparorDemo[]{new ComparorDemo(5),
                new ComparorDemo(2),
                new ComparorDemo(3),
                new ComparorDemo(6),
                new ComparorDemo(1)};

        for (int m = 0; m<comparorDemoArrys.length; m++){
            for (int n = 0; n<comparorDemoArrys.length - 1 - m; n++){
                if (comparorDemoArrys[n].compareTo(comparorDemoArrys[n+1]) > 0) {
                    ComparorDemo temp = comparorDemoArrys[n];
                    comparorDemoArrys[n] = comparorDemoArrys[n+1];
                    comparorDemoArrys[n+1] = temp;
                }
            }
        }

        for (int i = 0; i<comparorDemoArrys.length; i++){
            System.out.println(comparorDemoArrys[i].value);
        }

    }
}
