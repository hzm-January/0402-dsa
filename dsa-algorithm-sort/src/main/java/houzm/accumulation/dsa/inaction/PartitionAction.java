package houzm.accumulation.dsa.inaction;

import java.util.Arrays;

/**
 * author: hzm_dream@163.com
 * date: 2018/12/5 16:13
 * description:
 * <p>
 * 问题：求无序数组中的第k大元素
 * <p>
 * 分析：分区思想
 * <p>
 * 将数组进行原地分区操作
 * A[0, p-1] A[p] A[p+1, n-1]
 * K=p+1 那么 结果为A[p]
 * k>p+1 那么 结果在A[p+1]-A[n-1]之间 可再次分区处理
 * k<p+1 那么 结果在A[0]-A[p-1]之间 可再次分区处理
 */
public class PartitionAction {

    private static final int k = 3;

    public static void main(String[] args) {
        int[] arr = new int[]{ 8, 7, 6, 3, 5, 9, 4};
        int vauleK = find(arr);
        System.out.println(vauleK);

    }

    public static int find(int[] arr) {
        int valueK = find(arr, 0, arr.length - 1);
        return valueK;
    }

    private static int find(int[] arr, int start, int end) {
        System.out.println(" 数组：" + Arrays.toString(arr));
        System.out.println(" start：" + start + " end: " + end);
        int pivot = partition(arr, start, end);
        System.out.println(" 分区点：" + pivot);
        if (pivot + 1 == k) {
            return arr[pivot];
        }

        if (pivot + 1 > k) {
            return find(arr, pivot + 1, end);
        }
        return find(arr, start, pivot - 1);
    }

    /**
     * 寻找分区点，进行分区处理
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int p = start;
        int q = start;
        while (q < end) {
            if (arr[q] < pivot) {
                int temp = arr[q];
                arr[q] = arr[p];
                arr[p] = temp;
                p++;
            }
            q++;
        }
        int temp = arr[p];
        arr[p] = pivot;
        arr[end] = temp;
        return p;
    }
}
