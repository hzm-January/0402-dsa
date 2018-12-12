package houzm.accumulation.test.sort.square;

import houzm.accumulation.test.util.SortUtil;

import java.util.Arrays;

/**
 * author: hzm_dream@163.com
 * date: 2018/12/10 12:06
 * description: 测试练习冒泡排序
 *
 * lakh 量级：23234 ms ； 23s
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = SortUtil.initIntArray(SortUtil.LAKH);
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        long startTime = SortUtil.logStartTime();
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length-1; j > i ; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        SortUtil.logEndTime(startTime);
    }
}
