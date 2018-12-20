package houzm.accumulation.search.binary.multi;

import java.util.Arrays;

/**
 * author: hzm_dream@163.com
 * date: 2018/12/12 15:21
 * description: 二分查找重复元素第一次出现的索引
 */
public class BinarySearchFirst {
    public static void main(String[] args) {
        //生成目标数组
        int[] arr = new int[]{3, 5, 2, 7, 9, 4, 5, 2, 1, 6, 9};
//        int[] arr = new int[]{4, 5, 9, 8, 3, 1, 6, 7, 2};

        //1. 查找第一个目标元素
        System.out.println(0 + "在数组中的第一次出现的索引为：" + binarySearchFirst(arr, 0));
        System.out.println(2 + "在数组中的第一次出现的索引为：" + binarySearchFirst(arr, 2));
        System.out.println(5 + "在数组中的第一次出现的索引为：" + binarySearchFirst(arr, 5));
        System.out.println(9 + "在数组中的第一次出现的索引为：" + binarySearchFirst(arr, 9));
        System.out.println(10 + "在数组中的第一次出现的索引为：" + binarySearchFirst(arr, 10));

    }


    /**
     * 查找目标重复元素第一次出现的索引
     *
     * @param arr   原始数组
     * @param value 目标元素
     * @return
     */
    private static int binarySearchFirst(int[] arr, int value) {
        return binarySearchFirst(qSort(arr), value, 0, arr.length - 1);
    }

    /**
     * 查找目标重复元素第一次出现的索引
     *
     * @param arr   原始数组
     * @param value 目标元素
     * @param low   开始索引
     * @param high  结束索引
     * @return
     */
    private static int binarySearchFirst(int[] arr, int value, int low, int high) {
        while (low <= high) {
            int middle = low + ((high - low) >> 2);
            if (arr[middle] == value) {
                if (middle == 0 || arr[middle - 1] != value) {
                    return middle;
                }
                high = middle - 1;
            } else if (arr[middle] < value) {
                //下面的代码可以注释掉，将校验交给下次循环的入口条件low<=high
                /*if (middle == arr.length - 1) {
                //如果目标元素>数组中最大值，那么目标元素在目标数组中不存在返回-1
                    return -1;
                }
                if (arr[middle + 1] == value) {
                    return middle + 1;
                }*/
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    /**
     * 数组排序（不影响原始数组）
     *
     * @param arr 原始数组
     * @return 已排序的原始数组的拷贝数组
     */
    private static int[] qSort(int[] arr) {
        //1. 拷贝元素到新的数组
        int[] arrForSort = new int[arr.length];
        System.arraycopy(arr, 0, arrForSort, 0, arr.length);
        System.out.println("原始数组拷贝：" + Arrays.toString(arrForSort));
        //2. 排序--快速排序(O(nlogn))
        qSort(arrForSort, 0, arr.length - 1);
        System.out.println("数组排序结果：" + Arrays.toString(arrForSort));
        return arrForSort;
    }

    /**
     * 排序 --- 快速排序O(nlogn)
     *
     * @param arr   数组
     * @param start 开始索引
     * @param end   结束索引
     */
    private static void qSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        // 获取分区点

        int pivot = partition(arr, start, end);
        qSort(arr, start, pivot - 1);
        qSort(arr, pivot + 1, end);
    }

    /**
     * 获取分区点索引
     * 使用分治分区思想进行排序实现
     *
     * @param arr   数组
     * @param start 开始索引
     * @param end   结束索引
     * @return
     */
    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int p = start;
        int q = start;
        while (p != end && q != end) {
            if (arr[q] < pivot) {
                // 如果q小于pivot
                int temp = arr[q];
                arr[q] = arr[p];
                arr[p] = temp;
                p++;
            }
            q++;
        }
        arr[end] = arr[p];
        arr[p] = pivot;
        return p;
    }


}
