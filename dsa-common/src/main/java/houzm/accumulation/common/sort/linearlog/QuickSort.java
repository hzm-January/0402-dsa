package houzm.accumulation.common.sort.linearlog;

/**
 * author: hzm_dream@163.com
 * date: 2018/12/17 12:52
 * description: 排序 复杂度：线性对数阶
 * 1. 归并排序
 * 2. 快速排序
 */
public class QuickSort {

    /**
     * @param arr 原始数组
     * @return 已排序的原始数组的拷贝数组
     */
    public static int[] quickSort(int[] arr) {
        return quickSort(copyArr(arr), 0, arr.length - 1);
    }

    /**
     * 快速排序
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private static int[] quickSort(int[] arr, int start, int end) {
        //1. 退出条件
        if (start >= end) {
            return arr;
        }
        //2. 寻找分区点
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
        return arr;
    }

    /**
     * 寻找分区点
     * 分区点前的数据小于分区点处的值
     * 分区点后的数据大于分区点处的值
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private static int partition(int[] arr, int start, int end) {
        int pivotValue = arr[end];
        int p = start;
        int q = start;
        while (p != end && q != end) {
            if (arr[q] < pivotValue) {
                int temp = arr[q];
                arr[q] = arr[p];
                arr[p] = temp;
                p++;
            }
            q++;
        }
        arr[end] = arr[p];
        arr[p] = pivotValue;
        return p;
    }

    /**
     * 对数组进行拷贝
     *
     * @param arr
     * @return
     */
    private static int[] copyArr(int[] arr) {
        int[] arrCopy = new int[arr.length];
        System.arraycopy(arr, 0, arrCopy, 0, arr.length);
        return arrCopy;
    }


}
