package com.Sort;
import java.util.Arrays;
public class Insertion_sort {
    public static void main(String[] args) {
        int arr[] = {101, 34, 119, 1};
        System.out.println("原始数组：" + Arrays.toString(arr));
        processSelectSort2(arr);
    }
    private static void processSelectSort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 只是将这两句代码的代表当前要插入的下标用外循环的变量来代替了
            int currentInsertValue = arr[i];
            int insertIndex = i - 1;

            while (insertIndex >= 0
                    && currentInsertValue < arr[insertIndex]
            ) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = currentInsertValue;
            System.out.println("第 " + i + " 轮排序后：" + Arrays.toString(arr));
        }
    }
}
