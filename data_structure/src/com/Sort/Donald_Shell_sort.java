package com.Sort;
import java.util.Arrays;

public class Donald_Shell_sort {
    public static void main(String[] args) {
        int arr[] = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        System.out.println("原始数组：" + Arrays.toString(arr));
//        shellSort(arr);
        moveShellSort(arr);
    }
    public static void shellSort(int[] arr){
        int temp=0;
        //  第1层循环：得到每一次的增量步长
        for(int gap=arr.length/2;gap>0;gap/=2){
            //  第二层和第三层循环，是对每一个增量中的每一组数据进行插入排序
            for(int i = gap;i<arr.length;i++){
                for(int j=i-gap;j>=0;j-=gap){
                    if(arr[j]>arr[j+gap]){
                        temp=arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=temp;
                    }
                }
            }
            System.out.println("增量为 " + gap + " 的这一轮排序后：" + Arrays.toString(arr));
        }
    }
    /**
     * 插入排序采用移动法
     */
    public static void moveShellSort(int[] arr) {
        // 第 1 层循环：得到每一次的增量步长
        // 增量并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            /**
             这里的内层循环，除了是获得每一组的值（按增量取），
             移动法使用的是简单插入排序的算法 {@link InsertionSortTest#processSelectSort2(int[])}
             唯一不同的是，这里的组前一个是按增量来计算的
             */
            // 每一轮，都是针对某一个组的插入排序中：待排序的起点
            for (int i = gap; i < arr.length; i++) {
                int currentInsertValue = arr[i]; // 无序列表中的第一个元素
                int insertIndex = i - gap; // 有序列表中的最后一个元素
                while (insertIndex >= 0
                        && currentInsertValue < arr[insertIndex]) {
                    // 比较的数比前一个数小，则前一个往后移动
                    arr[insertIndex + gap] = arr[insertIndex];
                    insertIndex -= gap;
                }
                // 对找到的位置插入值
                arr[insertIndex + gap] = currentInsertValue;
            }
            System.out.println("增量为 " + gap + " 的这一轮排序后：" + Arrays.toString(arr));
        }
    }
}
