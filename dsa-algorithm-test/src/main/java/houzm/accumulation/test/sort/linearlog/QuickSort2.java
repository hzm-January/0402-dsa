package houzm.accumulation.test.sort.linearlog;

import java.util.Arrays;
import com.sun.javafx.scene.text.HitInfo;

/**
 * author: hzm_dream@163.com
 * date: 2019/2/18 15:34
 * description:
 */
public class QuickSort2 {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 7, 8, 6, 4, 1, 3, 5, 4, 2};
        int[] arrAfterSort = sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arrAfterSort));
    }

    private static int[] sort(int[] arr, int low, int high) {
        if (low >= high) {
            return arr;
        }
        //寻找中点
        int pivot = partition(arr, low, high);
        sort(arr, low, pivot-1);
        sort(arr, pivot+1, high);
        return arr;
    }

    private static int partition(int[] arr, int low, int high) {
        int point = arr[high];
        int p = low;
        int q = low;
        while (p < high && q<high) {
            if (arr[q] < point) {
                int temp = arr[p];
                arr[p] = arr[q];
                arr[q] = temp;
                p++;
            }
            q++;
        }
        arr[high] = arr[p];
        arr[p] = point;
        return p;
    }
}
