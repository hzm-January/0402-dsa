package houzm.accumulation.test.sort.square;

import houzm.accumulation.test.util.SortUtil;

import java.util.Arrays;

/**
 * author: hzm_dream@163.com
 * date: 2018/12/10 13:08
 * description: 测试练习选择排序
 *
 * lakh 量级：5039 ms； 5s
 *
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = SortUtil.initIntArray(SortUtil.LAKH);
        System.out.println("排序前：" + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        long startTime = SortUtil.logStartTime();
        for (int i = 0; i < arr.length-1; i++) {
            int reference = arr[i]; //最小值
            int index = -1; //最小值对应的索引
            for (int j = i + 1; j < arr.length; j++) {
                if (reference > arr[j]) {
                    reference = arr[j];
                    index = j;
                }
            }
            //交换元素
            if (index != -1) {
                int temp = arr[i];
                arr[i] = reference;
                arr[index] = temp;
            }
        }
        SortUtil.logEndTime(startTime);
    }
}
