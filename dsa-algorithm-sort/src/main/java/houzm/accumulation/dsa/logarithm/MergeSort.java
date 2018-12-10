package houzm.accumulation.dsa.logarithm;

import java.util.Arrays;

/**
 * author: hzm_dream@163.com
 * date: 2018/12/5 10:51
 * description: 归并排序(Merge Sort)
 *
 * 描述：分治思想
 *      寻找数组中点，切分数组，对前后数组进行排序之后合并
 *
 *
 * 1. 排序算法执行效率
 *      最好情况时间复杂度：O(nlogn)
 *      复杂度递推公式：
 *              n=1, T(1) = C;
 *              n>1, T(n) = 2*T(n/2)+n;
 *              n为元素个数
 *      综上所述：T(n) = 2^k*T(n/2^k)+kn, 假设n/2^k=1，那么k=以2为底的log n，代入公式得出：T(n)=O(nlogn)
 *
 *      最坏情况时间复杂度：O(nlogn)
 *      平均情况时间复杂度：O(nlogn)
 * 2. 排序算法内存消耗
 *      空间复杂度：O(n)
 * 3. 排序算法稳定性
 *      稳定
 *
 */
public class MergeSort {

    public static void main(String[] args) {
//        int[] arr = new int[]{6, 4, 5, 1, 3, 2};
        int[] arr = new int[]{3, 5, 5, 1, 3, 2};
        System.out.println(Arrays.toString(arr));
        int[] afterSortArr = sort(arr);
        System.out.println(Arrays.toString(afterSortArr));
    }

    public static int[] sort(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int[] mergeSort(int[] arr, int start, int end) {
        //1. 找到中点
        int middle = (start + end) / 2;
//        System.out.println(Arrays.toString(arr) + " " + start + " " + end + " " + middle);

        if (start >= end) {
            // 终止条件
            return new int[]{arr[middle]};
        } else {
            //2. 归并
            return merge(mergeSort(arr, start, middle), mergeSort(arr, middle + 1, end));
        }
    }

    private static int[] merge(int[] preSort, int[] nextSort) {
        System.out.println(Arrays.toString(preSort) + " " + Arrays.toString(nextSort));
        int[] arr = new int[preSort.length + nextSort.length];
        int p = 0;
        int q = 0;
        int k = 0;
        while (p < preSort.length && q < nextSort.length) {
            if (preSort[p] <= nextSort[q]) {
                arr[k++] = preSort[p++];
            } else {
                arr[k++] = nextSort[q++];
            }
        }
        if (p != preSort.length) {
            System.out.println("pre " + Arrays.toString(preSort) + " " + Arrays.toString(arr) + " " + p + " " + k + " " + " " + (preSort.length - p));
            System.arraycopy(preSort, p, arr, k, preSort.length - p);
        }
        if (q != nextSort.length) {
            System.out.println("next " + Arrays.toString(preSort) + " " + Arrays.toString(arr) + " " + p + " " + k + " " + " " + (preSort.length - p));
            System.arraycopy(nextSort, q, arr, k, nextSort.length - q);
        }
        return arr;
    }
}
