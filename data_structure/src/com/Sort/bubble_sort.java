package com.Sort;
import java.util.Arrays;
public class bubble_sort {
    public static void main(String[] args){
        bubble_sort bubble = new bubble_sort();
        int arr[] = {3, 9, -1, 10, -2};
//        bubble.process(arr);
        System.out.println("优化后输出");
        bubble.process1(arr);
    }

    /**
     * 基础代码
     * @param arr
     */
    public void process(int[] arr){
        int temp=0; //  零时变量
        for(int j=0;j<arr.length-1;j++){
            for(int i=0;i<arr.length-1-j;i++){
                if(arr[i]>arr[i+1]){
                    temp=arr[i];
                    arr[i+1]=arr[i];
                    arr[i]=temp;
                }
            }
            System.out.println("第 " + (j + 1) + " 趟排序后的数组");
            System.out.println(Arrays.toString(arr));
        }
    }
    public void process1(int[] arr){
        int temp = 0;
        boolean change=false;
        for(int j=0;j<arr.length-1;j++){
            change=false;
            for(int i=0;i<arr.length-1-j;i++){
                if(arr[i]>arr[i+1]){
                    temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                    change=true;
                }
            }
            if(!change){
                //  如果一轮下来没有排序，则可以提前退出
                break;
            }
            System.out.println("第 " + (j + 1) + " 趟排序后的数组");
            System.out.println(Arrays.toString(arr));
        }
    }

}
