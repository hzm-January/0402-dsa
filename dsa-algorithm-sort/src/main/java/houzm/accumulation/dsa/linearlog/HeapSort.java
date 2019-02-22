package houzm.accumulation.dsa.linearlog;

import java.util.Arrays;

/**
 * Author: hzm_dream@163.com
 * Date:  2019/2/22 22:43
 * Modified By:
 * Description：堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 5, 1, 3, 2};
        int[] sort = sort(arr);
        System.out.println(Arrays.toString(sort));
    }

    private static int[] sort(int[] arr) {
        //拷贝
        int[] copyArr = new int[arr.length];
        System.arraycopy(arr, 0, copyArr, 0, arr.length);
        System.out.println("原始：" + Arrays.toString(copyArr));
        //1. 建堆（从后往前）
        for (int i = (copyArr.length - 1 - 1) >> 1; i >= 0; i--) {
            heapify(copyArr, copyArr.length - 1, i);
        }
        System.out.println("建堆：" + Arrays.toString(copyArr));
        //2. 堆化（从上往下）
        int n = copyArr.length - 1;
        while (n > 0) {
            swap(copyArr, 0, n);
            --n;
            heapify(copyArr, n, 0);
        }
        return copyArr;
    }

    private static void swap(int[] arr, int m, int n) {
        int temp = arr[n];
        arr[n] = arr[m];
        arr[m] = temp;
    }

    private static void heapify(int[] arr, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 + 1 <= n && arr[i] < arr[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (i * 2 + 2 <= n && arr[maxPos] < arr[i * 2 + 2]) {
                maxPos = i * 2 + 2;
            }
            if (maxPos == i) {
                break;
            }
            swap(arr, i, maxPos);
            i = maxPos;
        }
    }
}
