package com.chenjw.review.sort;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {
        int [] arrs = {11, 0, 6, 1, 2, 5, 3};
        selectSort(arrs);
        System.out.println(Arrays.toString(arrs));
    }

    public static int[] selectSort(int [] arrs){
        for(int i = 0; i < arrs.length; i++){
            for (int j = i; j < arrs.length; j++){
                if(arrs[i] > arrs[j]){
                    int temp = arrs[i];
                    arrs[i] = arrs[j];
                    arrs[j] = temp;
                }
            }
        }
        return arrs;
    }


}
