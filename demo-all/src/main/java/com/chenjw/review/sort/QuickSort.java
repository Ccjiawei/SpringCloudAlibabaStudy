package com.chenjw.review.sort;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
//            {10, 7, 8, 9, 1, 5}
            // pi是分区操作后的基准元素的索引
            int pi = partition(arr, low, high);

            // 递归地排序基准元素左边和右边的子序列
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // 把最后一个元素设为基准
        int i = (low - 1);  // i是小于基准的元素的索引
        for (int j = low; j < high; j++) {
            // 如果当前元素小于或等于基准
            if (arr[j] <= pivot) {
                i++;

                // 交换arr[i]和arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 交换arr[i+1]和基准元素arr[high]
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted array: ");
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
    }
}
