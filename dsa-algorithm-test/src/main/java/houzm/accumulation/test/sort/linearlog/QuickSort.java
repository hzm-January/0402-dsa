package houzm.accumulation.test.sort.linearlog;

import houzm.accumulation.test.util.SortUtil;

import java.util.Arrays;

/**
 * author: hzm_dream@163.com
 * date: 2018/12/12 12:07
 * description: 测试联系快速排序
 *
 * 时间复杂度O(nlogn)
 * 空间复杂度O(1) 原地排序
 *
 * lakh量级：24ms ~ 48ms
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = SortUtil.initIntArray(SortUtil.LAKH);
        System.out.println(Arrays.toString(arr));
        long startTime = SortUtil.logStartTime();
        int[] arrAfterSort = quickSort(arr);
        SortUtil.logEndTime(startTime);
        System.out.println(Arrays.toString(arrAfterSort));
    }

    public static int[] quickSort(int[] arr) {
        return quickSort(arr, 0, arr.length - 1);
    }

    private static int[] quickSort(int[] arr, int start, int end) {
        //进行分区并进行排序
        if (start >= end) {
            return arr;
        }
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
        return arr;
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end]; //分区点
        int p = start;
        int q = start;
        while (p != end && q != end) {
            if (arr[q] < pivot) {
                int temp = arr[q];
                arr[q] = arr[p];
                arr[p] = temp;
                p++;
            }
            q++;
        }
        //设置分区点
        arr[end] = arr[p];
        arr[p] = pivot;
        return p;
    }
}
