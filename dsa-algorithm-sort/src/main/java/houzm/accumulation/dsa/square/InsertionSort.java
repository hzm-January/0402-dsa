package houzm.accumulation.dsa.square;

import java.util.Arrays;

/**
 * author: hzm_dream@163.com
 * date: 2018/12/4 16:15
 * description: 插入排序 (Insertion Sort)
 *
 * 描述：
 *      每次拿未排序区的第一个元素a和已排序区元素从后往前的元素b开始比较，如果b>a，往后移动一格，如果b<=a，将元素插入到b处索引+1位置
 *      无论如何优化：元素的移动次数==逆序度
 *
 * 1. 排序算法执行效率
 *      最好情况复杂度：O(n)
 *      最坏情况复杂度：O(n^2)
 *      平均情况复杂度：
 *          最好情况：有序度：n*(n-1)/2；逆序度：0；满有序度：n*(n-1)/2；逆序度为0，比较次数为n，移动次数为0；
 *          最坏情况：有序度：0；逆序度：n*(n-1)/2；满有序度：n*(n-1)/2；逆序度为n*(n-1)/2，比较次数为n^2，移动次数为n*(n-1)/2；
 *          综上所述：平均比较次数为n(n+1)/2，平均移动次数为n^2/4
 *          平均情况复杂度：O(n^2)
 * 2. 排序算法内存消耗(空间复杂度)：原地排序O(1)
 * 3. 排序算法稳定性：稳定---在比较移动处理过程中，不会交换相等元素的顺序
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 4, 5, 1, 3, 2};
//        int[] arr = new int[]{3, 5, 5, 1, 3, 2};
        System.out.println(Arrays.toString(arr));
        int[] sorted = sortNotChange(arr);
//        sortOptimize(arr);
        System.out.println(Arrays.toString(sorted));
    }

    private static int[] sortNotChange(int[] arr) {
        int[] copyArr = new int[arr.length];
        System.arraycopy(arr, 0, copyArr, 0, arr.length);
        for (int i = 1; i < copyArr.length; i++) {
            int temp = copyArr[i];
            for (int j = i-1; j >=0; j--) {
                if (temp > copyArr[j]) {
                    copyArr[j+1] = temp;
                    break;
                } else {
                    copyArr[j+1] = copyArr[j];
                }
                if (j == 0) {
                    copyArr[0] = temp;
                }
            }
        }
        return copyArr;
    }


    /**
     * 插入排序
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp =arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j]; //如果大于temp，向后移动一个位置
                }
                if (arr[j] <= temp) {
                    arr[j+1] = temp;
                    break;
                }
                if (j == 0) {
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 代码优化版
     * @param arr
     */
    public static void sortOptimize(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp =arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j]; //如果大于temp，向后移动一个位置
                } else if (arr[j] <= temp) {
                    break;
                }
            }
            arr[j+1] = temp;
        }
    }

}
