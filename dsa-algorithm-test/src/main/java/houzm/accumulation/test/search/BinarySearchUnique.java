package houzm.accumulation.test.search;

import houzm.accumulation.test.sort.linearlog.QuickSort;
import houzm.accumulation.test.util.SortUtil;

import java.util.Arrays;

/**
 * author: hzm_dream@163.com
 * date: 2018/12/21 13:47
 * description: 测试 二分查找 没有重复元素
 */
public class BinarySearchUnique {
    public static void main(String[] args) {
        int[] arr = SortUtil.initIntArrayNoRepeatDisorder(SortUtil.LAKH);
        int value = 99;
        //1. 对数组排序
        int[] arrAfterSort = QuickSort.quickSort(arr);
        System.out.println(Arrays.toString(arrAfterSort));
        //2. 二分查找
//        int index = binarySearch(arrAfterSort, value);
        int index = binarySearchRecursion(arrAfterSort, value);
        System.out.println(value + "在数组排序后的索引位置是：" + index);
        if (index != -1) {
            System.out.println(" 值是：" + arrAfterSort[index]);
        }
    }

    private static int binarySearch(int[] arr, int value) {
        return binarySearch(arr, value, 0, arr.length - 1);
    }

    private static int binarySearch(int[] arr, int value, int low, int high) {
        while (low <= high) {
            int middle = low + ((high - low) >> 2);
            if (arr[middle] == value) {
                return middle;
            } else if (arr[middle] < value) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    private static int binarySearchRecursion(int[] arr, int value) {
        return binarySearchRecursion(arr, value, 0, arr.length - 1);
    }

    private static int binarySearchRecursion(int[] arr, int value, int low, int high) {
        if (low > high) {
            return -1;
        }
        int middle = low + ((high - low) >> 2);
        if (arr[middle] == value) {
            return middle;
        } else if (arr[middle] < value) {
            return binarySearchRecursion(arr, value, middle + 1, high);
        } else {
            return binarySearchRecursion(arr, value, low, middle - 1);
        }
    }
}
