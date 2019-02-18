package houzm.accumulation.test.sort.linearlog;

import java.util.Arrays;

/**
 * author: hzm_dream@163.com
 * date: 2019/2/18 15:12
 * description:
 */
public class MergeSort2 {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 7, 8, 6, 4, 1, 3, 5, 4, 2};
        int[] arrAfterSort = sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arrAfterSort));
    }

    private static int[] sort(int[] arr, int start, int end) {
        int middle = start + ((end - start) >> 1);
        if (start >= end) {
            return new int[]{arr[middle]};
        }
        return merge(sort(arr, start, middle), sort(arr, middle + 1, end));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] arr = new int[left.length + right.length];
        int p = 0;
        int q = 0;
        int k = 0;
        while (p < left.length && q < right.length) {
            if (left[p] <= right[q]) {
                arr[k++] = left[p++];
            } else {
                arr[k++] = right[q++];
            }
        }
        if (p < left.length) {
            System.arraycopy(left, p, arr, k, left.length - p);
        }
        if (q < right.length) {
            System.arraycopy(right, q, arr, k, right.length - q);
        }
        return arr;
    }
}
