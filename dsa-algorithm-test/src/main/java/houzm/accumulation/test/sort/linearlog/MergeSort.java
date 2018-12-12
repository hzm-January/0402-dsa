package houzm.accumulation.test.sort.linearlog;

import houzm.accumulation.test.util.SortUtil;

import java.util.Arrays;

/**
 * author: hzm_dream@163.com
 * date: 2018/12/10 13:36
 * description: 测试练习归并排序
 * <p>
 * lakh量级：41ms
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = SortUtil.initIntArray(SortUtil.LAKH);
        System.out.println(Arrays.toString(arr));

        long startTime = SortUtil.logStartTime();
        int[] sortArr = mergeSort(arr);
        SortUtil.logEndTime(startTime);

        System.out.println(Arrays.toString(sortArr));

    }

    private static int[] mergeSort(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int[] mergeSort(int[] arr, int start, int end) {
        int middle = start + (end - start) / 2;
        if (start >= end) {
            return new int[]{arr[middle]};
        }
        return merge(mergeSort(arr, start, middle), mergeSort(arr, middle + 1, end));
    }

    private static int[] merge(int[] preArr, int[] behindArr) {
        int[] resultArr = new int[preArr.length + behindArr.length];
        int p = 0;
        int q = 0;
        int i = 0;
        while (p != preArr.length && q != behindArr.length) {
            if (preArr[p] <= behindArr[q]) {
                resultArr[i++] = preArr[p++];
            } else {
                resultArr[i++] = behindArr[q++];
            }
        }
        if (p != preArr.length) {
            System.arraycopy(preArr, p, resultArr, i, preArr.length - p);
        }
        if (q != behindArr.length) {
            System.arraycopy(behindArr, q, resultArr, i, behindArr.length - q);
        }
        return resultArr;
    }
}
