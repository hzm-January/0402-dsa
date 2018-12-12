package houzm.accumulation.dsa.linearlog;

import java.util.Arrays;

/**
 * author: hzm_dream@163.com
 * date: 2018/12/5 13:13
 * description: 快速排序(Quick Sort)
 * <p>
 * 描述：分治思想 和 分区思想
 *      取预分区点pivot：arr[arr.length-1]
 *      定义i记录交换次数
 *      分区处理：每次从未处理分区取出一个元素arr[j]，与预分区点进行比较，
 *              if(arr[j]<pivot) 交换arr[i]与arr[j]，并且i++，j++
 *              if(arr[j]>pivot) 不处理，j++
 * 1. 排序算法执行效率
 * 1.1 最好情况时间复杂度：O(nlogn)
 *      条件：每次分区点，都能将大区间对等的一分为二
 *      复杂度递推公式：
 *              n=1, T(1) = C;
 *              n>1, T(n) = 2*T(n/2)+n;
 *              n为元素个数
 * 1.2 最坏情况时间复杂度：O(n^2) 可以通过合理的选择pivot避免这种情况
 *      条件：每次分区点，都能将大区间分为9:1
 *      复杂度递推公式：
 *              n=1, T(1) = C;
 *              n>1, T(n) = T(n/10)+T(9*n/10)+n;
 *              n为元素个数
 * 1.3 平均情况时间复杂度：
 *
 * 2. 排序算法内存消耗(空间复杂度)：原地排序
 * 3. 排序算法稳定性：不稳定--在分区过程中，可能将相等元素位置交换
 *
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 8, 7, 6, 3, 5, 9, 4};
        System.out.println(Arrays.toString(arr));
        int[] afterSortArr = sort(arr);
        System.out.println(Arrays.toString(afterSortArr));
    }

    public static int[] sort(int[] arr) {
        return sort(arr, 0, arr.length - 1);
    }

    private static int[] sort(int[] arr, int start, int end) {
        //1. 终止条件
        if (start >= end) {
            return arr;
        }
        //1. 寻找分区点并进行分区
        int p = partition(arr, start, end);
        //2. 对分区点的前面区域和后面区域进行分区处理
        sort(arr, start, p - 1);
        sort(arr, p + 1, end);
        return arr;
    }

    /**
     * 寻找分区点并分区处理
     * 顺序： 从小到大
     * @param arr
     * @param start
     * @param end
     * @return 分区点
     */
    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start;
        int j = start;
        while (j < end) {
            if (arr[j] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
            j++;
        }
        arr[end] = arr[i];
        arr[i] = pivot;
        return i;
    }
}
