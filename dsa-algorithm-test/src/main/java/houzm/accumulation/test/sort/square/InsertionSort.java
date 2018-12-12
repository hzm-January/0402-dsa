package houzm.accumulation.test.sort.square;

import houzm.accumulation.test.util.SortUtil;

import java.util.Arrays;

/**
 * author: hzm_dream@163.com
 * date: 2018/12/10 12:27
 * description: 测试练习插入排序
 *
 * lakh 量级：10224 ms；10s
 *
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = SortUtil.initIntArray(SortUtil.LAKH);
        System.out.println("排序前：" + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        long logStartTime = SortUtil.logStartTime();
        for (int i = 1; i < arr.length; i++) {
            for (int j = i ; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        SortUtil.logEndTime(logStartTime);
    }
}
