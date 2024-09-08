package com.Sort;
import java.util.Arrays;
public class select_sort {
    public static void main(String[] args) {
        int arr[] = {101, 34, 119, 1};
        System.out.println("原始数组：" + Arrays.toString(arr));
        processSelectSort(arr);
    }

    private static void processSelectSort(int[] arr) {
        // 把之前假定当前最小值的地方，使用变量 i 代替了
        // 由于需要 arr.length -1 轮，所以使用外层一个循环，就完美的解决了这个需求
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i]; // 先假定第一个数为最小值
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 挨个与最小值对比，如果小于，则进行交换
                if (min > arr[j]) {
                    // 如果后面的值比当前的 min 小，则重置为这个数
                    min = arr[j];
                    minIndex = j;
                }
            }
            // 第 i 轮结束后，得到了最小值
            // 将这个最小值与 arr[i] 交换
            arr[minIndex] = arr[i];
            arr[i] = min;
            System.out.println("第 " + (i + 1) + " 轮排序后：" + Arrays.toString(arr));
        }
    }
    //  优化

    public void processSelectSort2(int[] arr) {
        // 把之前假定当前最小值的地方，使用变量 i 代替了
        // 由于需要 arr.length -1 轮，所以使用外层一个循环，就完美的解决了这个需求
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i]; // 先假定第一个数为最小值
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 挨个与最小值对比，如果小于，则进行交换
                if (min > arr[j]) {
                    // 如果后面的值比当前的 min 小，则重置为这个数
                    min = arr[j];
                    minIndex = j;
                }
            }
            // 第 i 轮结束后，得到了最小值
            // 将这个最小值与 arr[i] 交换
            if (minIndex == i) {
                // 如果最小值未发生改变，则不需要执行后面的交换了
                continue;
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
            System.out.println("第 " + (i + 1) + " 轮排序后：" + Arrays.toString(arr));
        }
    }

}
