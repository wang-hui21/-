package com.Sort;
import java.util.Arrays;
public class quick_sort {
    /**
     * 快速排序默写实现
     * <pre>
     *     基本思想：通过一趟将要排序的数据，分隔成独立的两个部分，一部分的所有数据都比另一部分的所有数据要小。
     *     思路分析：
     *      {-9, 78, 0, 23, -567, 70};  length=6
     *      1. 挑选中间的值作为 基准值：(0 + (6 -1))/2= [2] = 0
     *      2. 左侧 left 部分，从 0 开始到中间值 -1： 0,1: -9, 78,找出一个比基准值大的数
     *      3. 右侧 right 部分，从中间值 + 1 到数组大小-1：3,5：23,-567, 70，找出一个比基准值小的数
     *      4. 如果找到，则将他们进行交换，这样一轮下来，就完成了一次快速排序：一部分的所有数据都比另一部分的所有数据要小。
     *      4. 如果左侧部分还可以分组，则进行左侧递归调用
     *      5. 如果右侧部分还可以分组，则进行右侧递归调用
     *
     *    简单说：一轮快速排序示意图如下：
     *                   中间的基准值
     *      l ------------ pivot --------------- r
     *      一组从左往右找               一组从右往左找
     *      找到比基准值大的数          找出一个比基准值小的数
     *                    然后进行交换
     * </pre>
     */
    public static void main(String[] args) {
        int arr[] = {-9, 78, 0, 23, -567, 70};
//        int arr[] = {-9, 78, 0, -23, 0, 70}; // 在推导过程中，将会导致交换异常的数组，在这里不会出现那种情况
        int left = 0;
        int right = arr.length - 1;
        System.out.println("原始数组：" + Arrays.toString(arr));
        quickSort(arr, left, right);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        // 找到中间值
        int pivotIndex = (left + right) / 2;
        int pivot = arr[pivotIndex];
        int l = left;
        int r = right;
        while (l < r) {
            // 从左往右找，直到找到一个数，比基准值大的数
            while (arr[l] < pivot) {
                l++;
            }
            // 从右往左找，知道找到一个数，比基准值小的数
            while (arr[r] > pivot) {
                r--;
            }
            // 表示未找到
            if (l >= r) {
                break;
            }
            // 进行交换
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 那么下一轮，左侧的这个值将不再参与排序，因为刚交换过，一定比基准值小
            // 那么下一轮，右侧的这个值将不再参与排序，因为刚交换过，一定比基准值大
            r--;
            l++;
        }

        // 当一轮找完后，没有找到，则是中间值时，
        // 需要让他们插件而过，也就是重新分组，中间值不再参与分组
        // 否则，在某些情况下，会进入死循环
        if (l == r) {
            l++;
            r--;
        }
        // 如果左侧还可以继续分组，则继续快排
        // 由于擦肩而过了，那么左侧的组值，则是最初的开始与中间值的前一个，也就是这里得到的 r
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }
    }

}
