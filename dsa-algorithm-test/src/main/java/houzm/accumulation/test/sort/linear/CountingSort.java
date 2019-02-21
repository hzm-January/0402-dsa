package houzm.accumulation.test.sort.linear;

import java.util.Arrays;

/**
 * Author: hzm_dream@163.com
 * Date:  2019/2/21 20:48
 * Modified By:
 * Description：计数排序
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 8, 6, 6, 7, 5, 4, 4, 2, 2, 2, 1, 3};
        System.out.println(arr.length);
        int[] afterSortArr = sort(arr);
        System.out.println(Arrays.toString(afterSortArr));
    }

    private static int[] sort(int[] arr) {
        int max = max(arr);
        int min = min(arr);
        int length = max - min + 1;
        int [] countArr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i]-min]++;
        }
        System.out.println(Arrays.toString(countArr));
        for (int i = 1; i < countArr.length; i++) {
            countArr[i] +=countArr[i-1];
        }
        System.out.println(Arrays.toString(countArr));
        int [] temp = new int[arr.length];
        System.out.println(temp.length);
        for (int i = 0; i < arr.length; i++) {
            temp[(countArr[arr[i]-min]--)-1] = arr[i];
        }
        System.out.println(Arrays.toString(temp));
        return temp;
    }

    private static int max(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    private static int min(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }


}
