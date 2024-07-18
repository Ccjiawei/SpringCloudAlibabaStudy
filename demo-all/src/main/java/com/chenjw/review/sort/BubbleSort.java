package com.chenjw.review.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int [] arrs = {11, 0, 6, 1, 2, 5, 3};
        bubbleSort(arrs);
        System.out.println(Arrays.toString(arrs));
    }

    public static int[] bubbleSort(int [] arrs){

        for (int m = 0; m<arrs.length -1; m++){
            for (int n = 0; n<arrs.length - 1 - m; n++){
                if (arrs[n] > arrs[n+1]) {
                    int temp = arrs[n];
                    arrs[n] = arrs[n+1];
                    arrs[n+1] = temp;
                }
            }
        }
        return arrs;
    }


}
