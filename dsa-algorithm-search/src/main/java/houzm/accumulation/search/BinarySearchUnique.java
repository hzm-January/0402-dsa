package houzm.accumulation.search;

import java.util.Arrays;

/**
 * author: hzm_dream@163.com
 * date: 2018/12/12 12:45
 * description: 二分查找--元素无重复
 *
 *
 * 时间复杂度: 对数阶 O(logn)
 * 分析：
 *      假设数组有n个元素
 *      每次缩小1/2，最坏情况下缩小为空退出
 *      第一次缩小后元素个数：n/2
 *      第二次缩小后元素个数：n/4
 *      第三次缩小后元素个数：n/8
 *      ....
 *      第n次缩小后元素个数：n/2^k 此时元素个数有可能为1，有可能为空
 *      每次缩小后，只涉及两个数的大小比较，k次缩小，若n/2^k=1 时间复杂度为O(k)=O(logn)
 *
 *
 * 空间复杂度: O(1)
 *
 * 二分查找的局限性
 * 1. 二分查找依赖顺序结构(数组)
 * 原因：二分查找需要使用下标随机访问元素(数组O(1),链表O(n))，所以二分查找链表时间复杂度就不是O(logn)
 * 2. 二分查找针对有序数据或者插入/删除操作不频繁无序数据
 * 原因：
 * 二分查找前提条件是数据有序，如果数据无序必须先进行排序才能进行二分查找
 * 如果数据无序，并且插入和删除频繁，那么每次二分查找前的排序，即使使用O(nlogn)线性对数阶，也会有很大的成本
 * 如果数据无序，并且插入和删除频繁，不频繁，一次排序多次查找，可以使用二分查找
 * 3. 数据量太小不适合二分查找
 * 原因：
 * 如果数据量小，顺序遍历和二分查找的复杂度差不多，比如10个元素
 * 4. 数据量太大不适合二分查找
 * 原因：
 * 二分查找针对顺序结构(数组)，如果数据量为1G，那么内存必须有1G连续的地址，即使有2G的地址(没有连续的1G)，也不能进行数组申请
 *
 */
public class BinarySearchUnique {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 9, 8, 3, 1, 6, 7, 2};
        System.out.println(Arrays.toString(arr));
        //1. 插入排序
        sort(arr);
        System.out.println(Arrays.toString(arr));

        int indexOfExist = binarySearchRescursive(arr, 9);
        System.out.println(" index of exist in the arr " + indexOfExist);
        System.out.println(arr[indexOfExist]);

        int indexOfNotExist = binarySearchRescursive(arr, 10);
        System.out.println(" index of not exist in the arr " + indexOfNotExist);
        if (indexOfNotExist == -1) {
            System.out.println(" not exist ");
        } else {
            System.out.println(arr[indexOfNotExist]);
        }

    }


    /**
     * 二分查找--递归实现
     *
     * @param arr 目标数组
     * @param value 目标元素
     * @return 目标元素索引值
     */
    public static int binarySearchRescursive(int[] arr, int value) {
        return binarySearchRescursive(arr, value, 0, arr.length - 1);
//        return binarySearchNonRecursive(arr, value);
    }

    /**
     * 二分查找--非递归实现
     * @param arr 目标数组
     * @param value 目标元素
     * @return
     */
    private static int binarySearchNonRecursive(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = low + ((high - low) >> 2);
            if (arr[middle] == value) {
                return middle;
            } else if (arr[middle] < value) {
                low = middle + 1;
//                middle = middle + 1 + ((high - (middle + 1)) >> 2);
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找--递归实现
     *
     * @param arr
     * @param value
     * @param low
     * @param high
     * @return
     */
    private static int binarySearchRescursive(int[] arr, int value, int low, int high) {
        if (low > high) {
            return -1;
        }
        int middle = low + (high - low) / 2;
        if (arr[middle] == value) {
            return middle;
        } else if (arr[middle] < value) {
            return binarySearchRescursive(arr, value, middle + 1, high);
        } else {
            return binarySearchRescursive(arr, value, low, middle - 1);
        }
    }


    /**
     * 插入排序，生产可以考虑使用线性对数阶的排序算法实现
     *
     * @param arr 目标数组
     */
    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
